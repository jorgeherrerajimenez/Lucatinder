package lucatic.grupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.PerfilService;


/**
* @author Adnan H.
* @author Jorge H.
* @author Marco R.
* @author Maira P.
* @version 04/06/20
* @category MVC
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

	// Raíz
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET,
					value = "/registro")
	public String initForm(@ModelAttribute("perfil") Perfil perfil, Model model) {
		return "registro";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addPerfil")
	public ModelAndView addPerfil(Perfil perfil,Model model) {
		ModelAndView mv = new ModelAndView("mainmenu");
		mv.addObject("perfilUsuario", perfil);
		perfilService.add(perfil);	
		return mv;
	}
	
	//Lista de Sugerencias
	@RequestMapping(method= RequestMethod.GET, value= "/listaSugerencias")
	public ModelAndView mostrarPerfiles(@RequestParam("id") Long id, Model model) {
		Perfil perfilUsuario = this.perfilService.findById(id);
		
		ModelAndView mv = new ModelAndView("sugerencias");
	
		mv.addObject("perfilUsuario", perfilUsuario);
		mv.addObject("listaSugerencias", perfilService.showThreeProfiles());

		return mv;
	}
	
		// Lista de Contactos
		@RequestMapping(method = RequestMethod.GET, value = "/listaContactos")
		public ModelAndView mostrarContactos(@RequestParam("id") Long id, Model model) {
		ModelAndView mv = new ModelAndView("contactos");
			List<Contacto> contactos = this.contactoService.mostrarContactos(id);
			mv.addObject("contactos", contactos);
		return mv;
	}
		
		//Lista de Descartes
		@RequestMapping(method = RequestMethod.GET, value = "/listaDescartes")
		public ModelAndView mostrarDescartes(@RequestParam("id") Long id, Model model) {
		ModelAndView mv = new ModelAndView("descartes");
			List<Descarte> descartes = this.descarteService.mostrarDescartes(id);
			mv.addObject("descartes", descartes);
		return mv;
		}
		
		
	
	@RequestMapping(method= RequestMethod.GET, value= "/addContacto")
	public ModelAndView addContacto(@RequestParam("id") Long id1, @RequestParam("id2") Long id2) {
		
		//Añade a bd contactos
		this.contactoService.add(new Contacto(this.perfilService.findById(id1),
				this.perfilService.findById(id2)));
		
		Perfil perfilUsuario = this.perfilService.findById(id1);
		
		//Vuelve a cargar la pag sugerencias
		ModelAndView model = new ModelAndView("sugerencias");
		
		//Pregunta si hay me gustas asignados a ese perfil
		Long thereLikes = null;
		thereLikes = perfilService.showLikedProfiles(id2);
		
		
		if(thereLikes==0L) {
			model.addObject("perfilUsuario", perfilUsuario);
			model.addObject("listaSugerencias", perfilService.showThreeProfiles());
		}else {
			model.addObject("perfilUsuario", perfilUsuario);
			model.addObject("listaSugerencias", perfilService.showOthersProfiles(id1));
		}
		
		return model;
	}
	
}
