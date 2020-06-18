package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Role;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Repository
public interface DAORole extends JpaRepository<Role, Long> {
	
	List<Role> findByRole(String role);

}
