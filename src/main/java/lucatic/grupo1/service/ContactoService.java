package lucatic.grupo1.service;

import java.util.Collection;

import lucatic.grupo1.model.Contacto;

/**
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/

public interface ContactoService {

	public void add(Contacto contacto);
	public Collection<Contacto> findAll();
}
