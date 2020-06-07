package lucatic.grupo1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.PerfilService;

@RestController
@RequestMapping("/rperfil")
public class PerfilRESTController {
	
	@Autowired
	PerfilService perfilService;
	
	
	public PerfilRESTController(PerfilService perfilService) {
		
		this.perfilService = perfilService;
	}
	
	//para desplegar el error Antonio usa objetos de tipo Optional...
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class PerfilNotFoundException extends RuntimeException{
		
		public PerfilNotFoundException() {
			
			super("El perfil que buscas no existe");
		}
	}
	
	@RequestMapping(value="/sugerencias", method= RequestMethod.GET)
	public List<Perfil> mostrarSugerencias(){
		
		return perfilService.showTenProfiles();
	}
	
	@RequestMapping(value= "/add", method=RequestMethod.PUT)
	public void addPerfil(@RequestBody Perfil perfil) {
		
		System.out.println(perfil);
		this.perfilService.add(perfil);
		
	}
	
	
	
	//no funciona aún el método
	@GetMapping("/{id}")
	public Perfil getPerfil(@PathVariable Long id) {
		
	
		
		return perfilService.findById(id); }
		
		
		
	}
	

	
	
	
	
	


