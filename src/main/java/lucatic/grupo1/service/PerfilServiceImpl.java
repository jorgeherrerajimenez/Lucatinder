package lucatic.grupo1.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOPerfil;
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
	
	
	public void add(Perfil perfil) {	
		perfilDAO.save(perfil);	
	}
	
	@Override
	public void deleteById(Long id) {
		perfilDAO.deleteById(id);
	}
	
	public void generarNPerfilesFalsos(int number) {
		perfilDAO.saveAll(fakeFactory.generarNPerfiles(number));
	}
	
	@PostConstruct
	public void inicializar() {
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
	public List<Perfil> showOthersDislikesProfiles(Long id) {
		// TODO Auto-generated method stub
		return perfilDAO.showOthersDislikesProfiles(id);
	}

	@Override
	public List<Perfil> showTenProfiles() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Perfil findByUsername(String name) {
		// TODO Auto-generated method stub
		return perfilDAO.findByUsername(name);
	}

	@Override
	public Long showDislikedProfiles(Long id) {
		// TODO Auto-generated method stub
		return perfilDAO.showDislikedProfiles(id);
	}

	@Override
	public Long moreThanOneLike(long id, long id2) {
		// TODO Auto-generated method stub
		return perfilDAO.moreThanOneLike(id,id2);
	}

	@Override
	public Long moreThanOneDislike(long id, long id2) {
		// TODO Auto-generated method stub
		return perfilDAO.moreThanOneDislike(id,id2);
	}

}

