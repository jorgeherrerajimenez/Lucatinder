package lucatic.grupo1.service;

import java.util.List;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.rs.PerfilResponse;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
public interface DescarteService {
	
	public void add(Descarte descarte);
	
	public List<Descarte> mostrarDescartes(Long id);
	
	public List<PerfilResponse> mostrarDescartesREST(Long id);
	
}