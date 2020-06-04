package lucatic.grupo1.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Perfil;


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


