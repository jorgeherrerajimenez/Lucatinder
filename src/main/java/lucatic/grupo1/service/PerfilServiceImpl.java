package lucatic.grupo1.service;

import java.util.List;

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
	
	//Inyección de dependencia en capa servicios
	@Autowired
	private DAOPerfil perfilDAO;
	
	@Autowired
	private FakeFactory_I fakeFactory;
	
	@Autowired
	private DAORole roleDAO;
	
	
	public void add(Perfil perfil) {
		List<Role> r = roleDAO.findByRole("USER");
		perfil.setRoles(r);
		perfilDAO.save(perfil);	
	}
	
	@Override
	public void deleteById(Long id) {
		perfilDAO.deleteById(id);
	}
	
	public void generarNPerfilesFalsos(int number) {
		List<Perfil> perfiles = fakeFactory.generarNPerfiles(number);
		List<Role> r = roleDAO.findByRole("USER");
		for(Perfil p : perfiles)
			p.setRoles(r);
		perfilDAO.saveAll(perfiles);
	}
	
	@PostConstruct
	public void inicializar() {
		this.roleDAO.save(new Role("USER"));
		this.generarNPerfilesFalsos(12);
	}

	@Override
	public List<Perfil> generateCandidatesFor(Long id) {
		return perfilDAO.showTenProfiles();
		
	}
	
	@Override
	public Long showLikedProfiles(long id) {
		return perfilDAO.showLikedProfiles(id);
	}

	@Override
	public Perfil findById(Long id) {
		// TODO Auto-generated method stub
		return this.perfilDAO.getOne(id);
	}

	@Override
	public List<Perfil> showThreeProfiles() {
		// TODO Auto-generated method stub
		return perfilDAO.showThreeProfiles();
	}
	
	@Override
	public List<Perfil> showOthersProfiles(long id) {
		// TODO Auto-generated method stub
		return perfilDAO.showOthersProfiles(id);
	}

	@Override
	public Object showOthersDislikesProfiles(Long id) {
		// TODO Auto-generated method stub
		return perfilDAO.showOthersDislikesProfiles(id);
	}

	@Override
	public List<Perfil> showTenProfiles() {
		// TODO Auto-generated method stub
		return perfilDAO.showTenProfiles();
	}

	@Override
	public Perfil findByUsername(String name) {
		// TODO Auto-generated method stub
		return perfilDAO.findByUsername(name);
	}

}

