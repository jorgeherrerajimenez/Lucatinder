package lucatic.grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Descarte;

@Repository
public interface DAODescarte extends JpaRepository<Descarte,Long> {

	@Query("SELECT d from Descarte d WHERE d.descartador.id = :alias")
	List<Descarte> buscarDescartePorDescartador(@Param("alias") Long alias);
	
//	@Query(value = "SELECT p.nombre, p.edad, p.genero, p.descripcion, d.descartado_id, d.descartador_id from perfil p "
//			+ "INNER JOIN descarte d ON p.id = d.descartado_id WHERE p.id = 1028", nativeQuery = true)
//	List<Descarte> mostrarDatosDescartados();
}
