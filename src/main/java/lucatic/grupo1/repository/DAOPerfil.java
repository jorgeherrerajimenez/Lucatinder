package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Perfil;

/**
* @author Adnan H.
* @version 07/06/20
* @category MVC
*/

@Repository
public interface DAOPerfil extends JpaRepository<Perfil, Long>{
	
	//Devuelve si hay perfiles me gusta
	@Query(value = "select liked_id from contacto where liked_id= ?1", nativeQuery = true)
	public Long showLikedProfiles(long id);
	
	@Query(value = "select liked_id from descarte where descartado_id= ?1", nativeQuery = true)
	public Long showDislikedProfiles(long id);
	
	
	
	public Perfil findByUsername(String username);
	
	//Dame 3 perfil
	@Query(value = "SELECT * FROM perfil LIMIT 3", nativeQuery = true)
	public List<Perfil> showThreeProfiles();
	
	//Dame 10 perfil
	@Query(value = "SELECT * FROM perfil LIMIT 10", nativeQuery = true)
	public List<Perfil> showTenProfiles();

	//Dame 3 perfiles que no estén en la tabla "Contactos" Es decir, que ya les haya dado me gusta
	@Query(value = "SELECT * FROM perfil WHERE id NOT IN ( SELECT liked_id FROM contacto where liker_id=?1) LIMIT 3", nativeQuery = true)
	public List<Perfil> showOthersProfiles(long id);
	
	//Dame 3 perfiles que no estén en la tabla "Contactos" Es decir, que ya les haya dado me gusta
	@Query(value = "SELECT * FROM perfil WHERE id NOT IN ( SELECT descartado_id FROM descarte where descartador_id=?1) LIMIT 3", nativeQuery = true)
	public List<Perfil> showOthersDislikesProfiles(long id);

}

