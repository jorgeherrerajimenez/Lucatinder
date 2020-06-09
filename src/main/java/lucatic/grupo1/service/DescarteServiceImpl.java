package lucatic.grupo1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.model.rs.PerfilResponse;
import lucatic.grupo1.repository.DAODescarte;

@Service
public class DescarteServiceImpl implements DescarteService {
	
	@Autowired
	DAODescarte descarteDAO;
	
	
	@Override
	public void add(Descarte descarte) {
		descarteDAO.save(descarte);
	}
	
	@Override
	public List<Descarte> mostrarDescartes(Long id) {
		return descarteDAO.buscarDescartePorDescartador(id);
	}
	
	public List<PerfilResponse> mostrarDescartesREST(@RequestParam("id") Long id) {
		List<Descarte> descartes = this.descarteDAO.buscarDescartePorDescartador(id);
		List<PerfilResponse> listDescartes = new ArrayList<PerfilResponse>();
		for (Descarte descart : descartes) {
			PerfilResponse pr = new PerfilResponse();
			pr.setNombre(descart.getDescartado().getNombre());
			pr.setDescripcion(descart.getDescartado().getDescripcion());
			pr.setEdad(descart.getDescartado().getEdad());
			pr.setGenero(descart.getDescartado().getGenero());
			listDescartes.add(pr);
		}
	return listDescartes;
	}
}