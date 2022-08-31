package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Comentario;
import idat.edu.pe.daa2.jpa.repositorios.ComentarioRepositorio;

@Service
@Transactional
public class ComentarioServicio {
	
	@Autowired
	private ComentarioRepositorio repositorio;

	public ComentarioServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Comentario> buscarTodo() {
		return (List<Comentario>) repositorio.findAll();  
	}

	public Comentario crear(Comentario comentario) {
		return repositorio.save(comentario);
	}

	public Comentario actualizar(Comentario comentarioActualizar) {
		Comentario comentarioActual = repositorio.findById(comentarioActualizar.getID_COMENTARIO()).get();
		comentarioActual.setID_COMENTARIO(comentarioActualizar.getID_COMENTARIO());
		comentarioActual.setDESCRIPCION(comentarioActualizar.getDESCRIPCION());
	
		
		
		
		Comentario comentarioActualizado = repositorio.save(comentarioActual);
		return comentarioActualizado;
	}

	public Comentario buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
