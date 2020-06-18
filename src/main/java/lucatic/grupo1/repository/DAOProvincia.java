package lucatic.grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Provincia;

@Repository
public interface DAOProvincia extends JpaRepository<Provincia,Short> {

	public Provincia findByNombre(String nombre);
}
