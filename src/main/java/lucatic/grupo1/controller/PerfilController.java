package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.PerfilService;


/**
* @author Adnan H.
* @author Jorge H.
* @author Marco R.
* @author Maira Q.
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
	
	@RequestMapping(method= RequestMethod.GET, value= "/listaContactos")
	public ModelAndView mostrarPerfiles(@RequestParam("id") Long id, Model model) {
		Perfil perfilUsuario = this.perfilService.findById(id);
		ModelAndView mv = new ModelAndView("sugerencias");
		mv.addObject("perfilUsuario", perfilUsuario);
		mv.addObject("listaSugerencias", perfilService.showTenProfiles());
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/addContacto")
	public ModelAndView addContacto(@RequestParam("id") Long id1, @RequestParam("id2") Long id2) {
		this.contactoService.add(new Contacto(this.perfilService.findById(id1),
				this.perfilService.findById(id2)));
		ModelAndView model = new ModelAndView("contactoGuardado");
		return model;
	}
	
	//nuevo método para aceptar sugerencia
	//requestmethod.put
	//public void darLike()...
}
