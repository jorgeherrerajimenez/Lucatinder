package lucatic.grupo1.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.Provincia;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.service.ContactoService;
import lucatic.grupo1.service.DescarteService;
import lucatic.grupo1.service.MatchService;
import lucatic.grupo1.service.PerfilService;
import lucatic.grupo1.service.ProvinciaService;

/**
 * @author Adnan H.
 * @author Jorge H.
 * @author Marco R.
 * @author Maira Q.
 * @version 04/06/20
 */


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
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
	@Autowired
	ProvinciaService provinciaService;
	

	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class PerfilNotFoundException extends RuntimeException {
		public PerfilNotFoundException() {
			super("El perfil que buscas no existe");
		}
	}

	@RequestMapping(value = "/sugerencias/{id}", method = RequestMethod.GET)
	public List<PerfilResponse> mostrarSugerencias(@PathVariable("id") Long id) {

		LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR SUGERENCIAS");

		List<PerfilResponse> listaSugerencias = perfilService.generateCandidatesForResponse(id);
		return listaSugerencias;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addPerfil(@RequestBody Perfil perfil) {
		//perfil.setProvincia(this.provinciaService.findProvinciaByName(perfil.getProvincia().getNombre()));
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
	
	//Lista de Matches
		@RequestMapping(method = RequestMethod.GET, value= "/listaMatches/{id}")
		public List<PerfilResponse> mostrarMatches(@PathVariable("id") Long id){
			LOGGER.log(Level.INFO, "-EN CONTROLADOR PERFIL REST: MOSTRAR DESCARTES");
			List<PerfilResponse> listMatches = this.matchService.mostrarMatchesREST(id);
			return listMatches;
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/{username}")
		public PerfilResponse getOne(@PathVariable("username") String username) {
			PerfilResponse response = new PerfilResponse(perfilService.findByUsername(username));
			return response;
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/descartarSugerencia/{id}")
		public void descartarSugerencia(@PathVariable("id") Long id, @RequestBody PerfilResponse pr) {
			this.descarteService.add(new Descarte(this.perfilService.findById(id),
					this.perfilService.findById(pr.getId())));
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/aceptarSugerencia/{id}")
		public void aceptarSugerencia(@PathVariable("id") Long id, @RequestBody PerfilResponse pr) {
			this.contactoService.add(new Contacto(this.perfilService.findById(id),
					this.perfilService.findById(pr.getId())));
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/provincias")
		public List<Provincia> getProvincias(){
			return this.provinciaService.allProvincias();
		}
		
}