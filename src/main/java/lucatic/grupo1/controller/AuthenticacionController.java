package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOMateria;
import lucatic.grupo1.repository.DAOProvincia;

/**
* @author Jorge H.
* @version 05/06/20
*/

@Controller
public class AuthenticacionController {
	
	@Autowired
	private DAOMateria materiaDAO;
	
	@Autowired
	private DAOProvincia provinciaDAO;
	
	@GetMapping("/login")
	public ModelAndView loginForm() {
		return new ModelAndView("loginPersonalizado");
	}
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/registro")
	public ModelAndView initForm(@ModelAttribute("perfil") Perfil perfil, Model model) {
		ModelAndView mv = new ModelAndView("registro");
		mv.addObject("listaGustos", materiaDAO.findAll());
		mv.addObject("listaProvincias", provinciaDAO.findAll());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public RedirectView wrongUrlHandler() {
		return new RedirectView("/perfil/main");
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/error")
	public RedirectView errorRedirect() {
		return new RedirectView("/perfil/main");
	}
	
}
