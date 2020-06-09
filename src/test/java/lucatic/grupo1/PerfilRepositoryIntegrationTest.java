/*package lucatic.grupo1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lucatic.grupo1.model.Perfil;


import lucatic.grupo1.repository.DAOPerfil;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PerfilRepositoryIntegrationTest {
	
	

	
	@Autowired
	private DAOPerfil perfilDAO;
	
	
	/*@Test
	public void addDeleteTest() {
	 
		Perfil perfil = new Perfil("Marco Rueda","mrueda@gmail.com", "H".charAt(0), (short)27, "Soltero y amante de Python");
		
		Long numero = perfilDAO.count();

		perfilDAO.save(perfil);
		
		boolean existia = perfilDAO.existsById(perfil.getId());
		
		Long numeroSumado = perfilDAO.count();
		
		perfilDAO.deleteById(perfil.getId());
		
		boolean existe = perfilDAO.existsById(perfil.getId());
		
		assertThat(numeroSumado).isEqualTo(numero + 1);
		assertThat(existia).isTrue();
		assertThat(existe).isFalse();
		
	}

}*/
