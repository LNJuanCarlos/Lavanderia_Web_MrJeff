package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Opinion;
import idat.edu.pe.daa2.jpa.repositorios.OpinionRepositorio;

@Service
@Transactional
public class OpinionServicio {
	
	@Autowired
	private OpinionRepositorio repositorio;

	public OpinionServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Opinion> buscarTodo() {
		return (List<Opinion>) repositorio.findAll();  
	}

	public Opinion crear(Opinion opinion) {
		return repositorio.save(opinion);
	}

	public Opinion actualizar(Opinion opinionActualizar) {
		Opinion opinionActual = repositorio.findById(opinionActualizar.getID_OPINION()).get();
		opinionActual.setID_OPINION(opinionActualizar.getID_OPINION());
		opinionActual.setPUNTUACION(opinionActualizar.getPUNTUACION());
	
		
		
		
		Opinion opinionActualizado = repositorio.save(opinionActual);
		return opinionActualizado;
	}

	public Opinion buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
