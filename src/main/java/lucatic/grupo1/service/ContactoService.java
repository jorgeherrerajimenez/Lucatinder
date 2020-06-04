package lucatic.grupo1.service;

import java.util.Collection;

import lucatic.grupo1.model.Contacto;

public interface ContactoService {

	public void add(Contacto contacto);
	public Collection<Contacto> findAll();
}
