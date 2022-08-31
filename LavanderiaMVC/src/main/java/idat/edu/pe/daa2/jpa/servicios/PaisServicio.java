package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Pais;
import idat.edu.pe.daa2.jpa.repositorios.PaisRepositorio;

@Service
@Transactional
public class PaisServicio {
	
	@Autowired
	private PaisRepositorio repositorio;

	public PaisServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Pais> buscarTodo() {
		return (List<Pais>) repositorio.findAll();  
	}

	public Pais crear(Pais pais) {
		return repositorio.save(pais);
	}

	public Pais actualizar(Pais paisActualizar) {
		Pais paisActual = repositorio.findById(paisActualizar.getID_PAIS()).get();
		paisActual.setID_PAIS(paisActualizar.getID_PAIS());
		paisActual.setNOMBRE_PAIS(paisActualizar.getNOMBRE_PAIS());
		
	
		
		
		Pais paisActualizado = repositorio.save(paisActual);
		return paisActualizado;
	}

	public Pais buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}


}
