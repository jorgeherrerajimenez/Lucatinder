package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOPerfil;

@Controller
public class SecurityController {
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginPersonalizado";
	}
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/registro")
	public String initForm(@ModelAttribute("perfil") Perfil perfil, Model model) {
		return "registro";
	}
	
}
