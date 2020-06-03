package lucatic.grupo1.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DAOPerfilImpl {
	
	@PersistenceContext
	EntityManager entityManager;
	

	}


