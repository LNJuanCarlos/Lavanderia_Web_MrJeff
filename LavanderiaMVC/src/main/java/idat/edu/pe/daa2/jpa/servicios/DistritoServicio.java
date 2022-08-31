package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.repositorios.DistritoRepositorio;

@Service
@Transactional
public class DistritoServicio {
	
	@Autowired
	private DistritoRepositorio repositorio;

	public DistritoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Distrito> buscarTodo() {
		return (List<Distrito>) repositorio.findAll();  
	}

	public Distrito crear(Distrito cliente) {
		return repositorio.save(cliente);
	}

	public Distrito actualizar(Distrito distritoActualizar) {
		Distrito distritoActual = repositorio.findById(distritoActualizar.getID_DISTRITO()).get();
		distritoActual.setID_DISTRITO(distritoActualizar.getID_DISTRITO());
		distritoActual.setNOMBRE_DISTRITO(distritoActualizar.getNOMBRE_DISTRITO());
		
	
		
		
		Distrito distritoActualizado = repositorio.save(distritoActual);
		return distritoActualizado;
	}

	public Distrito buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
