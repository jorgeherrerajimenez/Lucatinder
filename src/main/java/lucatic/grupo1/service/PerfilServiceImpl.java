package lucatic.grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.repository.DAOPerfil;

//Componente servicios
@Service
public class PerfilServiceImpl implements PerfilService{
	
	//Inyección de dependencia en capa servicios
	@Autowired
	private DAOPerfil perfilDAO;

	@Override
	public void add(Perfil perfil) {
		// TODO Auto-generated method stub
		
		perfilDAO.save(perfil);
		
	}
	
	@Override
	public void deleteById(int id) {
		
		perfilDAO.deleteById((long) id);
	}
	

}
