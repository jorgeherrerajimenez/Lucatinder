package lucatic.grupo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@RequestMapping(method = RequestMethod.POST,
					value = "/add")
	public String addPerfil(@RequestParam("nombre") String nombre,
							@RequestParam("genero") char apellidos,
							@RequestParam("edad") short edad,
							@RequestParam("descripcion") String descripcion,
							Model model) {
		return "login";
	}
}
