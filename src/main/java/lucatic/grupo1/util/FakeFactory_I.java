package lucatic.grupo1.util;

import java.util.List;

import lucatic.grupo1.model.Perfil;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
public interface FakeFactory_I {
	
	public Perfil generarPerfil();
	
	public List<Perfil> generarNPerfiles(int number);

}
