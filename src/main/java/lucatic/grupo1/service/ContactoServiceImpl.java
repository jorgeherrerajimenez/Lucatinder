package lucatic.grupo1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lucatic.grupo1.model.Contacto;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAOContacto;

@Service
public class ContactoServiceImpl implements ContactoService {
	
	@Autowired
	private DAOContacto contactoDAO;
	
	
	@Override
	public void add(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	@Override
	public List<Contacto> mostrarContactos(Long id) {
		return contactoDAO.buscarContactosPorLiker(id);
	}
	
	@Override
	public List<PerfilResponse> mostrarContactosREST(Long id) {
		List<Contacto> contactos = this.contactoDAO.buscarContactosPorLiker(id);
		List<PerfilResponse> listContactos = new ArrayList<PerfilResponse>();
		for (Contacto contac : contactos) {
			PerfilResponse pr = new PerfilResponse();
			pr.setNombre(contac.getLiked().getNombre());
			pr.setDescripcion(contac.getLiked().getDescripcion());
			pr.setEdad(contac.getLiked().getEdad());
			pr.setGenero(contac.getLiked().getGenero());
			listContactos.add(pr);
		}
		return listContactos;
	}
}