package lucatic.grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.service.ContactoService;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
	ContactoService contactoService;
	
	@RequestMapping(method= RequestMethod.POST, value="/likes")
	public String aceptarSugerencia(Contacto contacto) {
		
		contactoService.add(contacto);
		return "/perfil/listaContactos";
		
	}
	

}
