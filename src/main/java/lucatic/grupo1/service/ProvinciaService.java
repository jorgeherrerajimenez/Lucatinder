package lucatic.grupo1.service;

import java.util.List;

import lucatic.grupo1.model.Provincia;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
public interface ProvinciaService {
	
	public Provincia findProvinciaByName(String name);
	
	public List<Provincia> allProvincias();

}
