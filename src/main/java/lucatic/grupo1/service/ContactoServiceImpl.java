package lucatic.grupo1.service;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.repository.DAOContacto;

/**
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/

public class ContactoServiceImpl implements ContactoService {
	
	@Autowired
	private DAOContacto contactoDAO;
	
	
	@Override
	public void add(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	@Override
	public Collection<Contacto> findAll() {
		return contactoDAO.findAll();
	}
}

