package lucatic.grupo1.util;

import java.util.List;

import lucatic.grupo1.model.Perfil;

public interface FakeFactory_I {
	
	public Perfil generarPerfil();
	
	public List<Perfil> generarNPerfiles(int number);

}
