package lucatic.grupo1.service;

import java.util.List;

import lucatic.grupo1.model.Descarte;

public interface DescarteService {
	
	public void add(Descarte descarte);
	
	public List<Descarte> mostrarDescartes(Long id);
	
//	public List<Descarte> mostrarDatosDescartes();
	
}