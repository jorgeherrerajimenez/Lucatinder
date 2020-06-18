package lucatic.grupo1.service;

import java.util.List;

import lucatic.grupo1.model.Materia;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
public interface MateriaService {
	
	public Materia getMateria(short id);
	
	public List<Materia> getAll();

}
