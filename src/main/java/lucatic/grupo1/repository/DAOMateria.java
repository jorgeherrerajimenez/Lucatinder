package lucatic.grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Materia;

@Repository
public interface DAOMateria extends JpaRepository<Materia,Short> {

}
