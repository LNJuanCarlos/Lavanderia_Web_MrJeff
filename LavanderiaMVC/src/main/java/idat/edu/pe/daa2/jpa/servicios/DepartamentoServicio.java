package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Departamento;
import idat.edu.pe.daa2.jpa.repositorios.DepartamentoRepositorio;

@Service
@Transactional
public class DepartamentoServicio {
	@Autowired
	private DepartamentoRepositorio repositorio;

	public DepartamentoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Departamento> buscarTodo() {
		return (List<Departamento>) repositorio.findAll();  
	}

	public Departamento crear(Departamento departamento) {
		return repositorio.save(departamento);
	}

	public Departamento actualizar(Departamento departamentoActualizar) {
		Departamento departamentoActual = repositorio.findById(departamentoActualizar.getID_DEPARTAMENTO()).get();
		departamentoActual.setID_DEPARTAMENTO(departamentoActualizar.getID_DEPARTAMENTO());
		departamentoActual.setNOMBRE_DEPARTAMENTO(departamentoActualizar.getNOMBRE_DEPARTAMENTO());
		
	
		
		
		Departamento departamentoActualizado = repositorio.save(departamentoActual);
		return departamentoActualizado;
	}

	public Departamento buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
