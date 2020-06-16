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
import lucatic.grupo1.model.Role;
import lucatic.grupo1.repository.DAOMateria;
import lucatic.grupo1.repository.DAOPerfil;
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

	@PostConstruct
	public void init() {
			LOGGER.log(Level.INFO, "POBLANDO BASE DE DATOS...");
			roleDAO.save(new Role("USER"));
			materiaDAO.save(new Materia("Python"));
			materiaDAO.save(new Materia("Java"));
			materiaDAO.save(new Materia("Otros"));
			this.generarPerfilesIniciales(12);
	}
	
	private void generarPerfilesIniciales(int number) {
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		Perfil def = new Perfil();
		def.generarDefault();
		def.setRoles(r);
		this.perfilDAO.save(def);
		for(Perfil p : perfiles)
			p.setRoles(r);
		try {
		perfilDAO.saveAll(perfiles);
		} catch (ConstraintViolationException ex) {
			ex.printStackTrace();
			perfilDAO.deleteAll();
			this.generarPerfilesIniciales(number);
		} catch (DataIntegrityViolationException ex) {
			perfilDAO.deleteAll();
			this.generarPerfilesIniciales(number);
		}
	}
	
}
