package lucatic.grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lucatic.grupo1.repository.DAOPerfil;

//Componente servicios
@Service
public class PerfilServiceImpl implements PerfilService{
	
	//Inyección de dependencia en capa servicios
	@Autowired
	private DAOPerfil perfilDAO;
	
	@Override
	public void add(Perfil perfil) {
		
		perfilDAO.save(perfil);
	}

}
