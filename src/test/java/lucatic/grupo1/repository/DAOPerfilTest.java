package lucatic.grupo1.repository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lucatic.grupo1.model.Perfil;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class DAOPerfilTest {
    
    @Autowired
    private  DAOPerfil dao;
    
    @BeforeAll
    void savePrueba() {
      dao.save(new Perfil("Prueba", "Prueba", 'H',(short) 20, "Prueba", null, null));
	}
    
    @AfterAll
    void deletePrueba() {
        dao.findByUsername("Prueba");
    }
    
    
    @Test
    void findByUserNameTest() {
        Perfil p = dao.findByUsername("Prueba");
        Assertions.assertNotNull(p);
        Assertions.assertEquals("Prueba", p.getUsername());
        Assertions.assertEquals((short) 20, p.getEdad());
    }
    
    
    @Test
    void testDos() {
    	Perfil p = dao.findByUsername("Prueba");
        Assertions.assertEquals("M", p.getGenero());
        Assertions.assertEquals("H", p.getGenero());
        Assertions.assertEquals("O", p.getGenero());
    }

}