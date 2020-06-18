package lucatic.grupo1.service;

import java.util.List;
import lucatic.grupo1.model.Perfil;
import lucatic.grupo1.model.rs.PerfilResponse;

/**
* @author Maira Q.
* @author Marco R.
* @author Adnan H.
* @author Jorge H.
* @version 04/06/20
*/

public interface PerfilService {
	
	public void add(Perfil perfil);
	public void deleteById(Long id);
	public List<Perfil> generateCandidatesFor(Long id);
	public Perfil findById(Long id);
	public Long showLikedProfiles(long id);
	public Long showDislikedProfiles(Long id2);
	public Perfil findByUsername(String name);
	public List<PerfilResponse> generateCandidatesForResponse(Long id);

}

