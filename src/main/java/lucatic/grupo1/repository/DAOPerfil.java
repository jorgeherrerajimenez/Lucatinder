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
	
	//Dame 10 perfil
	@Query(value = "SELECT * FROM perfil LIMIT 10", nativeQuery = true)
	public List<Perfil> showTenProfiles();

	@Query(value= "SELECT * FROM perfil p WHERE (p.id NOT IN (SELECT d.descartado_id FROM descarte d WHERE d.descartador_id = ?1 )) AND "
			+ "(p.id NOT IN (SELECT c.liked_id FROM contacto c WHERE c.liker_id= ?1) AND "
			+ "(p.id != ?1)) AND" + "(p.provincia IN (SELECT p.provincia FROM perfil p WHERE id=?1)) LIMIT 10", nativeQuery = true)
	public List<Perfil> generateCandidatesFor(Long id);
	
}

