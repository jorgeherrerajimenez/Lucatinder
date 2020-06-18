package lucatic.grupo1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import lucatic.grupo1.model.Match;

/**
* @author Jorge H.
* @version 10/06/20
*/

@Repository
public interface DAOMatch extends JpaRepository<Match,Long> {

	@Query(value = "SELECT * from matches m WHERE m.matcher_id = ?1", nativeQuery = true)
	List<Match> matchesByMatcher(Long id);
}
