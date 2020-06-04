package lucatic.grupo1.service;

import java.util.List;


import lucatic.grupo1.model.Perfil;

public interface PerfilService {
	
	public void add(Perfil perfil);
	public void deleteById(Long id);
	public List<Perfil> showTenProfiles();

}

