package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	PerfilService perfilService;

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
	public String addPerfil(Perfil perfil,Model model) {
		perfilService.add(perfil);
		return "mainmenu";
	}
}
