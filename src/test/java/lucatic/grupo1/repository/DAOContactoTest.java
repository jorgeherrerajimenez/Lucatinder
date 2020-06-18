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
import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.Perfil;

//@author Jorge H.


@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class DAOContactoTest {
    
    @Autowired
    private DAOContacto contactos;
    
    @Autowired
    private DAOPerfil perfil;
    
    private Contacto c1,c2;
    private Perfil p1,p2,p3;
    @BeforeAll
    void setUpBeforeClass() throws Exception {
    	this.p1 = new Perfil("Prueba1", "Prueba1", 'H',(short) 20, "Prueba1", null, null);
        this.p2 = new Perfil("Prueba2", "Prueba2", 'M',(short) 20, "Prueba2", null, null);
        this.p3 = new Perfil("Prueba3", "Prueba3", 'O',(short) 20, "Prueba3", null, null);
        perfil.save(p1);
        perfil.save(p2);
        perfil.save(p3);
        this.c1 = new Contacto(p1,p2);
        this.c2 = new Contacto(p1,p3);
        contactos.save(this.c1);
        contactos.save(this.c2);
    }
//  
    @AfterAll
    void clear() {
        for(Contacto c : contactos.findAll()) {
            c.setLiked(null);
            c.setLiker(null);
            contactos.save(c);
            contactos.delete(c);
        }
        perfil.delete(perfil.findByUsername("Prueba1"));
        perfil.delete(perfil.findByUsername("Prueba2"));
        perfil.delete(perfil.findByUsername("Prueba3"));
    }
    @Test
    void contactosByLikerTest() {
        Assertions.assertTrue(perfil.findByUsername("Prueba1").getContactos().size() == 2);
        Assertions.assertTrue(perfil.findByUsername("Prueba2").getContactoDe().size() == 1);
        Assertions.assertTrue(perfil.findByUsername("Prueba3").getContactoDe().size() == 1);
        
    }
}