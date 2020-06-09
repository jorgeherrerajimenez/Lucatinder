package lucatic.grupo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Descarte;
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

//	@Override
//	public List<Descarte> mostrarDatosDescartes() {
//		return descarteDAO.mostrarDatosDescartados();
//	}

	
	
	
}