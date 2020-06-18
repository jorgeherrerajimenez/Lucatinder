package lucatic.grupo1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Match;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAOMatch;

/**
* @author Jorge H.
* @version 11/06/20
*/

@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private DAOMatch matchDAO;

	@Override
	public void add(Match match) {
		// TODO Auto-generated method stub
		matchDAO.save(match);
	}

	@Override
	public List<Match> matchesByMatcher(Long id) {
		// TODO Auto-generated method stub
		return matchDAO.matchesByMatcher(id);
	}

	@Override
	public List<PerfilResponse> mostrarMatchesREST(Long id) {
		// TODO Auto-generated method stub
		List<Match> matches = this.matchDAO.matchesByMatcher(id);
		List<PerfilResponse> listResponse = new ArrayList<PerfilResponse>();
		for (Match mtch : matches) {
			PerfilResponse pr = new PerfilResponse(mtch.getMatched());
			listResponse.add(pr);
		}
		return listResponse;
	}

	

}
