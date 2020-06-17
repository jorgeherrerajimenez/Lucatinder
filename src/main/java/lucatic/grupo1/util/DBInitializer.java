package lucatic.grupo1.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import lucatic.grupo1.controller.PerfilRESTController;
import lucatic.grupo1.model.Materia;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.Provincia;
import lucatic.grupo1.model.Role;
import lucatic.grupo1.repository.DAOMateria;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.repository.DAOProvincia;
import lucatic.grupo1.repository.DAORole;

@Component
public class DBInitializer {
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());
	
	@Autowired
	private FakeFactory_I fakeFactory;
	
	@Autowired
	DAORole roleDAO;
	
	@Autowired
	DAOPerfil perfilDAO;
	
	@Autowired
	DAOMateria materiaDAO;
	
	@Autowired
	DAOProvincia provinciaDAO;

	@PostConstruct
	public void init() {
			LOGGER.log(Level.INFO, "POBLANDO BASE DE DATOS...");
			roleDAO.save(new Role("USER"));
			materiaDAO.save(new Materia("Python"));
			materiaDAO.save(new Materia("Java"));
			materiaDAO.save(new Materia("Otros"));
			provinciaDAO.save(new Provincia("Alava"));
			provinciaDAO.save(new Provincia("Albacete"));
			provinciaDAO.save(new Provincia("Alicante"));
			provinciaDAO.save(new Provincia("Almería"));
			provinciaDAO.save(new Provincia("Asturias"));
			provinciaDAO.save(new Provincia("Ávila"));
			provinciaDAO.save(new Provincia("Badajoz"));
			provinciaDAO.save(new Provincia("Barcelona"));
			provinciaDAO.save(new Provincia("Burgos"));
			provinciaDAO.save(new Provincia("Cáceres"));
			provinciaDAO.save(new Provincia("Cádiz"));
			provinciaDAO.save(new Provincia("Cantabria"));
			provinciaDAO.save(new Provincia("Castellón"));
			provinciaDAO.save(new Provincia("Ciudad Real"));
			provinciaDAO.save(new Provincia("Córdoba"));
			provinciaDAO.save(new Provincia("Cuenca"));
			provinciaDAO.save(new Provincia("Gerona"));
			provinciaDAO.save(new Provincia("Granada"));
			provinciaDAO.save(new Provincia("Guadalajara"));
			provinciaDAO.save(new Provincia("Guipúzcoa"));
			provinciaDAO.save(new Provincia("Huelva"));
			provinciaDAO.save(new Provincia("Huesca"));
			provinciaDAO.save(new Provincia("Islas Baleares"));
			provinciaDAO.save(new Provincia("Jaén"));
			provinciaDAO.save(new Provincia("La Coruña"));
			provinciaDAO.save(new Provincia("La Rioja"));
			provinciaDAO.save(new Provincia("Las Palmas"));
			provinciaDAO.save(new Provincia("León"));
			provinciaDAO.save(new Provincia("Lérida"));
			provinciaDAO.save(new Provincia("Lugo"));
			provinciaDAO.save(new Provincia("Madrid"));
			provinciaDAO.save(new Provincia("Málaga"));
			provinciaDAO.save(new Provincia("Murcia"));
			provinciaDAO.save(new Provincia("Navarra"));
			provinciaDAO.save(new Provincia("Orense"));
			provinciaDAO.save(new Provincia("Palencia"));
			provinciaDAO.save(new Provincia("Pontevedra"));
			provinciaDAO.save(new Provincia("Salamanca"));
			provinciaDAO.save(new Provincia("Santa Cruz de Tenerife"));
			provinciaDAO.save(new Provincia("Segovia"));
			provinciaDAO.save(new Provincia("Sevilla"));
			provinciaDAO.save(new Provincia("Soria"));
			provinciaDAO.save(new Provincia("Tarragona"));
			provinciaDAO.save(new Provincia("Teruel"));
			provinciaDAO.save(new Provincia("Toledo"));
			provinciaDAO.save(new Provincia("Valencia"));
			provinciaDAO.save(new Provincia("Valladolid"));
			provinciaDAO.save(new Provincia("Bilbao"));
			provinciaDAO.save(new Provincia("Zamora"));
			provinciaDAO.save(new Provincia("Zaragoza"));
			
			this.generarNPerfilesFalsos(12);
	}
	
	private void generarNPerfilesFalsos(int number) {
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		for(Perfil p : perfiles)
			p.setRoles(r);
		try {
		perfilDAO.saveAll(perfiles);
		} catch (ConstraintViolationException ex) {
			ex.printStackTrace();
			perfilDAO.deleteAll();
			this.generarNPerfilesFalsos(number);
		} catch (DataIntegrityViolationException ex) {
			perfilDAO.deleteAll();
			this.generarNPerfilesFalsos(number);
		}
	}
	

		
		
		
		
		
	
}
