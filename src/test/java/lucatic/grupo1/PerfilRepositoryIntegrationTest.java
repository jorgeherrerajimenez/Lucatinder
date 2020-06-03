package lucatic.grupo1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lucatic.grupo1.model.Materia;
import lucatic.grupo1.model.Perfil;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import lucatic.grupo1.repository.DAOPerfil;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PerfilRepositoryIntegrationTest {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DAOPerfil perfilDAO;
	
	
	
	public void addDeleteTest() {
	 
		Perfil perfil = new Perfil("Marco Rueda", "H".charAt(0), (short)27, "Soltero y amante de Python");
		
		Long numero = perfilDAO.count();

		perfilDAO.save(perfil);
		
		boolean existia = perfilDAO.existsById(perfil.getId());
		
		Long numeroSumado = perfilDAO.count();
		
		perfilDAO.deleteById(perfil.getId());
		
		boolean existe = perfilDAO.existsById(perfil.getId());
		
		assertThat(numeroSumado).isEqualTo(numero + 1);
	}

}
