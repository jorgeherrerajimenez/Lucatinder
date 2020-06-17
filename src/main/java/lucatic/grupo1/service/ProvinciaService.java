package lucatic.grupo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Provincia;

public interface ProvinciaService {
	
	public Provincia getProvincia(short id);
	public List<Provincia> getAll();
	

}
