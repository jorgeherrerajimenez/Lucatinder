package lucatic.grupo1.service;

import java.util.List;

import lucatic.grupo1.model.Provincia;

public interface ProvinciaService {
	
	public Provincia findProvinciaByName(String name);
	
	public List<Provincia> allProvincias();

}
