package lucatic.grupo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.repository.DAOProvincia;
import lucatic.grupo1.model.Provincia;


@Service
public class ProvinciaServiceImpl implements ProvinciaService {
	
	@Autowired
	DAOProvincia provinciaDAO;
	
	public Provincia getProvincia(short id) {
		
		return provinciaDAO.getOne(id);
	}
	
	public List<Provincia> getAll(){
		
		return provinciaDAO.findAll();
	}
	
	

}
