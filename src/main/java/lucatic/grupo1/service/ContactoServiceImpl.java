package lucatic.grupo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.controller.PerfilRESTController;
import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Match;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAOContacto;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Service
public class ContactoServiceImpl implements ContactoService {
	
	@Autowired
	private DAOContacto contactoDAO;
	
	@Autowired 
	private MatchService matchService;
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());
	
	//Añadir un contacto
	@Override
	public void add(Contacto contacto) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS (CONTACTO): AÑADIENDO UN PERFIL A LA LISTA DE CONTACTOS");	
		contactoDAO.save(contacto);
		
		Perfil p1 = contacto.getLiker();
		Perfil p2 = contacto.getLiked();
		
		if (p2.getContactos().contains(new Contacto(p2,p1))) {
			matchService.add(new Match(p1,p2));
			LOGGER.log(Level.INFO, "MATCH GENERADO: "+ p1.getUsername() + " and " + p2.getUsername());
			matchService.add(new Match(p2,p1));
			LOGGER.log(Level.INFO, "MATCH GENERADO: "+ p2.getUsername() + " and " + p1.getUsername());
		}
	}
	
	//Buscar contactos por ID de usuario
	@Override
	public List<Contacto> mostrarContactos(Long id) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS(CONTACTO): BUSCANDO CONTACTOS EN BASE AL ID DEL USUARIO");
		return contactoDAO.buscarContactosPorLiker(id);
	}
	
	//Lista de contactos para servicio rest
	@Override
	public List<PerfilResponse> mostrarContactosREST(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS(CONTACTO): CREANDO LISTA DE CONTACTOS PARA EL SERVICIO REST");
		
		List<Contacto> contactos = this.contactoDAO.buscarContactosPorLiker(id);
		List<PerfilResponse> listContactos = new ArrayList<PerfilResponse>();
		for (Contacto contac : contactos) {
			PerfilResponse pr = new PerfilResponse(contac.getLiked());
			listContactos.add(pr);
		}
		return listContactos;
	}
}