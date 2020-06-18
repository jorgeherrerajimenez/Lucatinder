package lucatic.grupo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.Match;
import lucatic.grupo1.model.Materia;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.MatchService;
import lucatic.grupo1.service.MateriaService;
import lucatic.grupo1.service.PerfilService;

/**
* @author Jorge H.
 * @author Jorge H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@Autowired
	ContactoService contactoService;

	@Autowired
	DescarteService descarteService;
	
	@Autowired
	MatchService matchService;
	
	@Autowired 
	MateriaService materiaService;

	// Crea un logger en la clase PerfilController
	private final static Logger LOGGER = Logger.getLogger(PerfilController.class.getName());

	// Raíz, genera una entrada (previa autenticación) a la página general de la
	// aplicación
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView handleRequest(Authentication auth) throws Exception {

		LOGGER.log(Level.INFO,
				"- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO PARA PROCESAR LA ENTRADA A LA APLICACIÓN");

		ModelAndView model = new ModelAndView("mainmenu");
		model.addObject("perfil", perfilService.findByUsername(auth.getName()));
		return model;
	}
	
	//Dar de alta un usuario
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/addPerfil")
	public RedirectView addPerfil(@RequestParam(value = "gustos", required = false) short[] gustos,Perfil perfil,Model model) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO AÑADIR PERFIL");
		perfil.setGustosInformaticos(new ArrayList<Materia>());
		for(short i: gustos)
			perfil.getGustosInformaticos().add(materiaService.getMateria(i));
		perfil.encodePassword();
		perfilService.add(perfil);
		return new RedirectView("/login");
	}

	// Lista de Sugerencias
	@RequestMapping(method = RequestMethod.GET, value = "/listaSugerencias")
	public ModelAndView mostrarPerfiles(@RequestParam("id") Long id, Model model) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO MOSTRAR PERFILES");
		Perfil perfilUsuario = this.perfilService.findById(id);
		ModelAndView mv = new ModelAndView("sugerencias");
		mv.addObject("perfilUsuario", perfilUsuario);
		mv.addObject("listaSugerencias", perfilService.generateCandidatesFor(id));
		return mv;
		
	}

	// Lista de Contactos
	@RequestMapping(method = RequestMethod.GET, value = "/listaContactos")
	public ModelAndView mostrarContactos(@RequestParam("id") Long id, Model model) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO MOSTRAR CONTACTOS");
		ModelAndView mv = new ModelAndView("contactos");
		List<Contacto> contactos = this.contactoService.mostrarContactos(id);
		mv.addObject("contactos", contactos);
		return mv;
		
	}

	// Lista de Descartes
	@RequestMapping(method = RequestMethod.GET, value = "/listaDescartes")
	public ModelAndView mostrarDescartes(@RequestParam("id") Long id, Model model) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO MOSTRAR DESCARTES");
		ModelAndView mv = new ModelAndView("descartes");
		List<Descarte> descartes = this.descarteService.mostrarDescartes(id);
		mv.addObject("descartes", descartes);
		return mv;
		
	}
	
	//Lista de matches
	@RequestMapping(method = RequestMethod.GET, value = "/listaMatches")
	public ModelAndView mostrarMatches(@RequestParam("id") Long id, Model model) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO MOSTRAR MATCHES");
		ModelAndView mv = new ModelAndView("matches");
		List<Match> matches = this.matchService.matchesByMatcher(id);
		mv.addObject("matches", matches);
		return mv;
		
	}
	
		
	/* El Usuario añade a una sugerencia a Contactos tras dar 'Like' a través del 
	Front (/listaSugerencias) y se le redirige a la lista de sugerencias de nuevo */
	@RequestMapping(method = RequestMethod.GET, value = "/addContacto")
	public RedirectView addContacto(@RequestParam("id") Long id1, @RequestParam("id2") Long id2) {
		
		LOGGER.log(Level.INFO, "- EN CONTROLADOR DE PERFIL: DENTRO DEL MÉTODO MOSTRAR DESCARTES");
		
		Perfil p1 = this.perfilService.findById(id1);
		Perfil p2 = this.perfilService.findById(id2);
		
		this.contactoService.add(new Contacto(p1, p2));
		
		LOGGER.log(Level.INFO, "CONTACTO GENERADO: "+ p1.getUsername() + " and " + p2.getUsername());
		
		return new RedirectView("/perfil/listaSugerencias?id="+id1);
	}
	

	/* El Usuario añade a una sugerencia a Descartes tras dar 'DisLike' a través del
	   Front (/listaSugerencias) y se le redirige a la lista de sugerencias de nuevo */
	@RequestMapping(method = RequestMethod.GET, value = "/addDescarte")
	public RedirectView addDescarte(@RequestParam("id") Long id1, @RequestParam("id2") Long id2) {

		Perfil p1 = this.perfilService.findById(id1);
		Perfil p2 = this.perfilService.findById(id2);
		
		this.descarteService.add(new Descarte(p1, p2));
		
		LOGGER.log(Level.INFO, "DESCARTE GENERADO: "+ p1.getUsername() + " and " + p2.getUsername());
		
		return new RedirectView("/perfil/listaSugerencias?id="+id1);
	}
	
}
