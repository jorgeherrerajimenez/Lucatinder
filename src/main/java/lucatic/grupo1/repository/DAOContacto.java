package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Contacto;

/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */

@Repository
public interface DAOContacto extends JpaRepository <Contacto, Long> {

	@Query("SELECT c from Contacto c WHERE c.liker.id = :alias")
	List<Contacto> buscarContactosPorLiker(@Param("alias") Long alias);
}
