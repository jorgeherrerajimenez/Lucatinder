package lucatic.grupo1.service;

import java.util.List;
import lucatic.grupo1.model.Perfil;

/**
* @author Maira Q.
* @author Marco R.
* @author Adnan H.
* @author Jorge H.
* @version 04/06/20
* @category MVC
*/

public interface PerfilService {
	
	public void add(Perfil perfil);
	public void deleteById(Long id);
	public List<Perfil> generateCandidatesFor(Long id);
	public Perfil findById(Long id);
	public Long showLikedProfiles(long id);
	public List<Perfil> showTenProfiles();
	public List<Perfil> showThreeProfiles();
	public List<Perfil> showOthersProfiles(long id);
	public List<Perfil> showOthersDislikesProfiles(Long id1);
	public Perfil findByUsername(String name);


}

