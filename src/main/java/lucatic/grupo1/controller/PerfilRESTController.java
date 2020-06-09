package lucatic.grupo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Descarte;
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
public class PerfilRESTController {

	@Autowired
	PerfilService perfilService;
	
	@Autowired
	ContactoService contactoService;
	
	@Autowired
	DescarteService descarteService;
	

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
