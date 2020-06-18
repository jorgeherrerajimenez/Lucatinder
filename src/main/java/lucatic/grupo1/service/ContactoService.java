package lucatic.grupo1.service;

import java.util.List;
import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.rs.PerfilResponse;


/**
* @author Maira Q.
* @version 04/06/20
*/

public interface ContactoService {
	
	public void add(Contacto contacto);
	
	public List<Contacto> mostrarContactos(Long id);
	
	public List<PerfilResponse> mostrarContactosREST(Long id);
	
}
