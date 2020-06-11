package lucatic.grupo1.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.Role;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.repository.DAORole;
import lucatic.grupo1.util.FakeFactory_I;

/**
* @author Jorge H.
* @author Marco R.
* @author Adnan H.
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/


//Componente servicios
@Service
public class PerfilServiceImpl implements PerfilService{
	
	private final static Logger LOGGER = Logger.getLogger(PerfilService.class.getName());

	
	//Inyección de dependencia en capa servicios
	@Autowired
	private DAOPerfil perfilDAO;
	
	@Autowired
	private FakeFactory_I fakeFactory;
	
	@Autowired
	private DAORole roleDAO;
	
	

	//Añadir registro en base de datos
	public void add(Perfil perfil) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: AÑADIENDO PERFIL");
		List<Role> r = roleDAO.findByRole("USER");
		perfil.setRoles(r);
		perfilDAO.save(perfil);	
	}
	
	//Borrar registro de la base de datos por ID
	@Override
	public void deleteById(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: BORRANDO PERFIL POR ID");

		
		perfilDAO.deleteById(id);
	}
	
	//Generar perfiles Faker para rellenar la base de datos
	public void generarNPerfilesFalsos(int number) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: GENERANDO PERFILES FALSOS");
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		for(Perfil p : perfiles)
			p.setRoles(r);
		perfilDAO.saveAll(perfiles);

	}
	
	//Inicializando método de generación de perfiles falsos
	@PostConstruct
	public void inicializar() {
		this.roleDAO.save(new Role("USER"));
		this.generarNPerfilesFalsos(12);
	}
	
	//Mandando perfiles falsos del DAO a la capa de control
	@Override
	public List<Perfil> generateCandidatesFor(Long id) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: GENERANDO DIEZ PERFILES FALSOS EN BASE AL ID");

		return perfilDAO.showTenProfiles();
		
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
	
	//Mostrar tres perfiles de la base de datos
	@Override
	public List<Perfil> showThreeProfiles() {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: MOSTRANDO TRES PERFILES");

		
		// TODO Auto-generated method stub
		return perfilDAO.showThreeProfiles();
	}
	
	//Método para mostrar perfiles distintos a los que ya se les ha dado 'like'
	//Con esto buscamos que una vez que se le de 'like' a un perfil, desaparezca de la vista de sugerencias
	@Override
	public List<Perfil> showOthersProfiles(long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: MOSTRAR PERFILES QUE NO ESTÉN ENTRE LOS 'ME GUSTA'");

		// TODO Auto-generated method stub
		return perfilDAO.showOthersProfiles(id);
	}
	
	
	//Una función idéntica al método de arriba pero para los descartes, a los que se les ha dado 'no me gusta'
	@Override
	public List<Perfil> showOthersDislikesProfiles(Long id) {
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: MOSTRANDO PERFILES QUE NO ESTÉN ENTRE LOS DESCARTES");
		// TODO Auto-generated method stub
		return perfilDAO.showOthersDislikesProfiles(id);
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

	@Override
	public List<Perfil> showTenRandomProfilesOtherThanUser(Long id) {
		
		LOGGER.log(Level.INFO, "EN CAPA SERVICIOS: SELECCIONANDO DIEZ PERFILES ALEATORIOS");
		// TODO Auto-generated method stub
		return perfilDAO.showTenRandomProfilesOtherThanUser(id);
	}

}

