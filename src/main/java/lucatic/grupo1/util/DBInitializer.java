package lucatic.grupo1.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Component
public class DBInitializer {
	
	private final static Logger LOGGER = Logger.getLogger(PerfilRESTController.class.getName());
	
	@Autowired
	private FakeFactory_I fakeFactory;
	
	@Autowired
	DAOPerfil perfilDAO;
	
	@Autowired
	DAOMateria materiaDAO;
	
	@Autowired
	DAORole roleDAO;
	
	@Autowired
	DAOProvincia provinciaDAO;
	
	private List<Provincia> provincias;
	private Random r = new Random();
	

	@PostConstruct
	public void init() {
			LOGGER.log(Level.INFO, "POBLANDO BASE DE DATOS...");
			roleDAO.save(new Role("USER"));
			this.initMateria();
			this.initProvincia();
			this.provincias = this.provinciaDAO.findAll();
			this.generarPerfilesIniciales(25);
	}
	
	private void generarPerfilesIniciales(int number) {
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		if(this.perfilDAO.findByUsername("default") == null) {
			Perfil def = new Perfil();
			def.generarDefault();
			def.setRoles(r);
			this.perfilDAO.save(def);
		}
		for(Perfil p : perfiles) {
			p.setRoles(r);
			p.setProvincia(this.provincias.get(this.r.nextInt(this.provincias.size())));
		}
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
	
	private void initProvincia() {
		List<String> list = Arrays.asList("A Coruña", "Álava","Albacete","Alicante","Almería", "Asturias", "Ávila",
			"Badajoz", "Baleares", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", 
			"Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipúzkoa", 
			"Huelva", "Huesca","Jaén", "La Rioja","Las Palmas", "León","Lérida", "Lugo", "Madrid","Málaga", 
			"Murcia", "Navarra", "Ourense", "Palencia", "Pontevedra", "Salamanca", "Segovia", "Sevilla", "Soria", 
			"Tarragona", "Santa Cruz de Tenerife", "Teruel", "Toledo", "Valencia", "Valladolid", "Bilbao",
			"Zamora", "Zaragoza");
		for(String s : list)
			this.provinciaDAO.save(new Provincia(s));
	}
	
	private void initMateria() {
		materiaDAO.save(new Materia("Python"));
		materiaDAO.save(new Materia("Java"));
		materiaDAO.save(new Materia("Otros"));
	}
	
}
