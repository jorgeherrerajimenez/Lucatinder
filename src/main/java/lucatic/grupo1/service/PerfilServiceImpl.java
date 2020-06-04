package lucatic.grupo1.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOPerfil;
import lucatic.grupo1.util.FakeFactory_I;

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
		this.generarNPerfilesFalsos(20);
	}

	@Override
	public List<Perfil> showTenProfiles() {
		return perfilDAO.showTenProfiles();
	}

	@Override
	public Perfil findById(Long id) {
		// TODO Auto-generated method stub
		return this.perfilDAO.getOne(id);
	}

}

