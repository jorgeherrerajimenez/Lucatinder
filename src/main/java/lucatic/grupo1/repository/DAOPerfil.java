package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Perfil;

@Repository
public interface DAOPerfil extends JpaRepository<Perfil, Long>{
	
	
	//Dame 10 perfiles
	@Query(
			  value = "SELECT * FROM lucatinder.perfil LIMIT 10", 
			  nativeQuery = true)
	public List<Perfil> showTenProfiles();
	
	
	public Perfil findByUsername(String username);
	
}

