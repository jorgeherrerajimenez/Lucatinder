package lucatic.grupo1.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//Componente repositorio
//@Repository
public class DAOPerfilImpl {

	//creo el entityManager para futuros métodos que implementemos y no vengan en JPARepository.
	@PersistenceContext
	EntityManager entityManager;
	

	}


