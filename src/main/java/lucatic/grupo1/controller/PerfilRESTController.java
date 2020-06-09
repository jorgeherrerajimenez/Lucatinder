package lucatic.grupo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.PerfilService;
/**
* @author Adnan H.
* @author Jorge H.
* @author Marco R.
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/
@RestController
@RequestMapping("/rperfil")
public class PerfilRESTController {
	
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	ContactoService contactoService;
	
	@Autowired
	DescarteService descarteService;
	
	//para desplegar el error Antonio usa objetos de tipo Optional...
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class PerfilNotFoundException extends RuntimeException{
		public PerfilNotFoundException() {
			super("El perfil que buscas no existe");
		}
	}
	
	@RequestMapping(value="/sugerencias", method= RequestMethod.GET)
	public List<Perfil> mostrarSugerencias(@RequestParam("id") Long id){
		return perfilService.showThreeProfiles();
	}
	
	@RequestMapping(value= "/add", method=RequestMethod.PUT)
	public void addPerfil(@RequestBody Perfil perfil) {
		this.perfilService.add(perfil);
	}
	
	// Lista de Contactos
		@RequestMapping(method = RequestMethod.GET, value = "/listaContactos")
		public List<PerfilResponse> mostrarContactos(@RequestParam("id") Long id) {
			List<PerfilResponse> listContactos = this.contactoService.mostrarContactosREST(id);
			return listContactos;
		}
		
	// Lista de Descartes
		@RequestMapping(method = RequestMethod.GET, value = "/listaDescartes")
		public List<PerfilResponse> mostrarDescartes(@RequestParam("id") Long id) {
			List<PerfilResponse> listDescartes = this.descarteService.mostrarDescartesREST(id);
			return listDescartes;
		}
}
