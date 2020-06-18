package lucatic.grupo1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.controller.PerfilRESTController;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.Role;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.repository.DAORole;

/**
* @author Jorge H.
* @author Marco R.
* @author Adnan H.
* @author Maira Q.
* @version 04/06/20
*/


//Componente servicios
@Service
public class PerfilServiceImpl implements PerfilService{
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());

	
	//Inyección de dependencia en capa servicios
	@Autowired
	private DAOPerfil perfilDAO;
	
	@Autowired
	private DAORole roleDAO;
	
	
	//Añadir registro en base de datos
	public void add(Perfil perfil) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: AÑADIENDO PERFIL");
		List<Role> r = roleDAO.findByRole("USER");
		perfil.setRoles(r);
		if (perfil.getGenero() == 'H')
			perfil.setImage("genero_masculino/usericonboy.jpg");
		else
			perfil.setImage("genero_femenino/usericongirl.jpg");
		perfilDAO.save(perfil);	
	}
	
	//Borrar registro de la base de datos por ID
	@Override
	public void deleteById(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: BORRANDO PERFIL POR ID");

		
		perfilDAO.deleteById(id);
	}
	
	
	//Mandando perfiles falsos del DAO a la capa de control
	@Override
	public List<Perfil> generateCandidatesFor(Long id) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: GENERANDO CANDIDATOS PARA USUARIO CON ID "+id);
		
		List<Perfil> result = this.perfilDAO.generateCandidatesByProvince(id);
		if (result.size() < 6) {
			List<Perfil> resultLowPriority = this.perfilDAO.generateCandidatesFor(id);
			for(Perfil p : resultLowPriority)
				if ((result.size()<6)&&(!result.contains(p)))
					result.add(p);
		}
		
		return result;
		
	}
	
	@Override
	public List<PerfilResponse> generateCandidatesForResponse(Long id) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: GENERANDO DIEZ PERFILES FALSOS EN BASE AL ID RESPONSE");
		
		List<Perfil> contactos = this.perfilDAO.generateCandidatesFor(id);
		List<PerfilResponse> listContactos = new ArrayList<PerfilResponse>();
		for (Perfil contac : contactos) {
			PerfilResponse pr = new PerfilResponse(contac);
			listContactos.add(pr);
		}
		return listContactos;
	}
	
		
	//Mostrar perfiles a los que se les ha dado Like
	@Override
	public Long showLikedProfiles(long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: MOSTRANDO LA LISTA DE 'ME GUSTA'");

		
		return perfilDAO.showLikedProfiles(id);
	}
	
	//Buscar un perfil en base a su ID
	@Override
	public Perfil findById(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: BUSCANDO A UN PERFIL POR SU ID");

		// TODO Auto-generated method stub
		return this.perfilDAO.getOne(id);
	}
	
	//Buscar usuario en base a su nombre (no ID)
	@Override
	public Perfil findByUsername(String name) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: BUSCANDO A UN USUARIO POR SU NOMBRE");
		// TODO Auto-generated method stub
		return perfilDAO.findByUsername(name);
	}
	
	//Muestra usuarios a los que se les ha dado 'dislike'
	@Override
	public Long showDislikedProfiles(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: MOSTRANDO DISLIKES");

		// TODO Auto-generated method stub
		return perfilDAO.showDislikedProfiles(id);
	}

}

