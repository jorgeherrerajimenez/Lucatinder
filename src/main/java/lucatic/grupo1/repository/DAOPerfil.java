package lucatic.grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucatic.grupo1.model.Perfil;

@Repository
public interface DAOPerfil extends JpaRepository<Perfil, Long>{


}
