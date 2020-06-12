package lucatic.grupo1.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.MatchService;
import lucatic.grupo1.service.PerfilService;

/**
* @author Adnan H.
* @author Jorge H.
* @author Marco R.
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/

@CrossOrigin(origins="http:localhost:8080", maxAge=3600)
@RestController
@RequestMapping("/rperfil")
public class PerfilRESTController {
	
	
	@Autowired
	PerfilService perfilService;
	@Autowired
	ContactoService contactoService;
	@Autowired
	DescarteService descarteService;
	@Autowired
	MatchService matchService;
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());
	
	
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class PerfilNotFoundException extends RuntimeException{
		public PerfilNotFoundException() {
			super("El perfil que buscas no existe");
		}
	}
	@RequestMapping(value="/sugerencias/{id}", method= RequestMethod.GET)
	public List<Perfil> mostrarSugerencias(@PathVariable("id") Long id){
		
		LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR SUGERENCIAS");
		
		return perfilService.generateCandidatesFor(id);
	}
	@RequestMapping(value= "/add", method=RequestMethod.PUT)
	public void addPerfil(@RequestBody Perfil perfil) {
		
		LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: AÑADIR PERFIL");
		
		this.perfilService.add(perfil);
	}
	// Lista de Contactos
		@RequestMapping(method = RequestMethod.GET, value = "/listaContactos/{id}")
		public List<PerfilResponse> mostrarContactos(@PathVariable("id") Long id) {
			
			LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR CONTACTOS");
			
			List<PerfilResponse> listContactos = this.contactoService.mostrarContactosREST(id);
			return listContactos;
		}
		
	// Lista de Descartes
		@RequestMapping(method = RequestMethod.GET, value = "/listaDescartes/{id}")
		public List<PerfilResponse> mostrarDescartes(@PathVariable("id") Long id) {
			
			LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR DESCARTES");
			
			List<PerfilResponse> listDescartes = this.descarteService.mostrarDescartesREST(id);
			return listDescartes;
		}
		
	//Lista Matches 
		@RequestMapping(method = RequestMethod.GET, value= "/listaMatches")
		public List<PerfilResponse> mostrarMatches(@RequestParam("id") Long id){
			
			LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR DESCARTES");
			List<PerfilResponse> listMatches = this.matchService.mostrarMatchesREST(id);
			return listMatches;
		}
		
}