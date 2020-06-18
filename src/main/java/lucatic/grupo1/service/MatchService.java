package lucatic.grupo1.service;

import java.util.List;
import lucatic.grupo1.model.Match;
import lucatic.grupo1.model.rs.PerfilResponse;

/**
* @author Jorge H.
* @version 10/06/20
*/

public interface MatchService {

	public void add(Match match);
	
	public List<Match> matchesByMatcher(Long id);
	
	public List<PerfilResponse> mostrarMatchesREST(Long id);
}
