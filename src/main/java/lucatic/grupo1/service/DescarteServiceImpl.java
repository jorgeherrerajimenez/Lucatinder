package lucatic.grupo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import lucatic.grupo1.controller.PerfilRESTController;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAODescarte;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Service
public class DescarteServiceImpl implements DescarteService {
	
	@Autowired
	DAODescarte descarteDAO;
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());

	
	//Añadir descartes
	@Override
	public void add(Descarte descarte) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS(DESCARTE): AÑADIENDO DESCARTE");
		
		descarteDAO.save(descarte);
	}
	
	//Mostrar descartes por ID
	@Override
	public List<Descarte> mostrarDescartes(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS(DESCARTE): MOSTRANDO DESCARTE POR ID DE USUARIO");

		
		return descarteDAO.buscarDescartePorDescartador(id);
	}
	
	//Lista de descartes para el servicio REST
	public List<PerfilResponse> mostrarDescartesREST(@RequestParam("id") Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS(DESCARTE): LISTA DE DESCARTES PARA EL SERVICIO REST");

		List<Descarte> descartes = this.descarteDAO.buscarDescartePorDescartador(id);
		List<PerfilResponse> listDescartes = new ArrayList<PerfilResponse>();
		for (Descarte descart : descartes) {
			PerfilResponse pr = new PerfilResponse(descart.getDescartado());
			listDescartes.add(pr);
		}
	return listDescartes;
	}
}