package lucatic.grupo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucatic.grupo1.model.Materia;
import lucatic.grupo1.repository.DAOMateria;

@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired 
	private DAOMateria materiaDAO;

	@Override
	public Materia getMateria(short id) {
		// TODO Auto-generated method stub
		return materiaDAO.getOne(id);
	}

	@Override
	public List<Materia> getAll() {
		// TODO Auto-generated method stub
		return materiaDAO.findAll();
	}

	
}
