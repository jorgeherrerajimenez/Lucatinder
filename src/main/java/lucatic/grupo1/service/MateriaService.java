package lucatic.grupo1.service;

import java.util.List;

import lucatic.grupo1.model.Materia;

public interface MateriaService {
	
	public Materia getMateria(short id);
	
	public List<Materia> getAll();

}
