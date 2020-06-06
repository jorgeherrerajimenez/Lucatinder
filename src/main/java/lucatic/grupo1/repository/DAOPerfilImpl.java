package lucatic.grupo1.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/

//Componente repositorio
//@Repository
public class DAOPerfilImpl {

	//creo el entityManager para futuros métodos que implementemos y no vengan en JPARepository.
	@PersistenceContext
	EntityManager entityManager;
	
	
	
	
}


