package lucatic.grupo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Provincia;
import lucatic.grupo1.repository.DAOProvincia;
/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */
@Service
public class ProvinciaServiceImpl implements ProvinciaService {
	
	@Autowired
	private DAOProvincia provinciaDAO;

	@Override
	public Provincia findProvinciaByName(String name) {
		// TODO Auto-generated method stub
		return this.provinciaDAO.findByNombre(name);
	}

	@Override
	public List<Provincia> allProvincias() {
		// TODO Auto-generated method stub
		return provinciaDAO.findAll();
	}

}
