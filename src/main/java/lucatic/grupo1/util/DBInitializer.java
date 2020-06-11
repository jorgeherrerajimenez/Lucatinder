package lucatic.grupo1.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lucatic.grupo1.controller.PerfilRESTController;
import lucatic.grupo1.model.Materia;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.Role;
import lucatic.grupo1.repository.DAOMateria;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.repository.DAORole;
import lucatic.grupo1.service.PerfilService;

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
			this.generarNPerfilesFalsos(12);
	}
	
	private void generarNPerfilesFalsos(int number) {
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		for(Perfil p : perfiles)
			p.setRoles(r);
		perfilDAO.saveAll(perfiles);
	}
	
}
