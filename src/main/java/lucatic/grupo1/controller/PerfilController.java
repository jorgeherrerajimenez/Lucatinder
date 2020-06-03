package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(method = RequestMethod.GET,
					value = "/registro")
	public String initForm(@ModelAttribute("perfil") Perfil perfil, Model model) {
		return "registro2";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addPerfil(Perfil perfil,Model model) {
		perfilService.add(perfil);
		return "mainmenu";
	}
}
