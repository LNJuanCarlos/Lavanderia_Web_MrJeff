package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Incidencias;
import idat.edu.pe.daa2.jpa.repositorios.IncidenciasRepositorio;

@Service
@Transactional
public class IncidenciasServicio {
	
	@Autowired
	private IncidenciasRepositorio repositorio;

	public IncidenciasServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Incidencias> buscarTodo() {
		return (List<Incidencias>) repositorio.findAll();  
	}

	public Incidencias crear(Incidencias incidencias) {
		return repositorio.save(incidencias);
	}

	public Incidencias actualizar(Incidencias incidenciasActualizar) {
		Incidencias incidenciasActual = repositorio.findById(incidenciasActualizar.getID_INCIDENCIAS()).get();
		incidenciasActual.setID_INCIDENCIAS(incidenciasActualizar.getID_INCIDENCIAS());
		incidenciasActual.setASUNTO_INC(incidenciasActualizar.getASUNTO_INC());
		incidenciasActual.setDESCRIPCION_INC(incidenciasActualizar.getDESCRIPCION_INC());
		incidenciasActual.setESTADO_INC(incidenciasActualizar.getESTADO_INC());
		incidenciasActual.setFEC_INC(incidenciasActualizar.getFEC_INC());
		
		
		
		Incidencias incidenciasActualizado = repositorio.save(incidenciasActual);
		return incidenciasActualizado;
	}

	public Incidencias buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
