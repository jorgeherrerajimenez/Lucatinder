package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Descarte;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Repository
public interface DAODescarte extends JpaRepository<Descarte,Long> {

	@Query("SELECT d from Descarte d WHERE d.descartador.id = :alias")
	List<Descarte> buscarDescartePorDescartador(@Param("alias") Long alias);
	
}
