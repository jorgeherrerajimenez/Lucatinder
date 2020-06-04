package lucatic.grupo1.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import lucatic.grupo1.model.Descarte;
import lucatic.grupo1.repository.DAODescarte;

public class DescarteServiceImpl implements DescarteService {
	
	@Autowired
	DAODescarte descarteDAO;
	@Override
	public void add(Descarte descarte) {
		descarteDAO.save(descarte);
	}
	@Override
	public Collection<Descarte> findAll() {
		return descarteDAO.findAll();
	}
}