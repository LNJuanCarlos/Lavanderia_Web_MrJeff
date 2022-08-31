package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Empleado;
import idat.edu.pe.daa2.jpa.repositorios.EmpleadoRepositorio;

@Service
@Transactional
public class EmpleadoServicio {
	
	@Autowired
	private EmpleadoRepositorio repositorio;

	public EmpleadoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Empleado> buscarTodo() {
		return (List<Empleado>) repositorio.findAll();  
	}

	public Empleado crear(Empleado empleado) {
		return repositorio.save(empleado);
	}

	public Empleado actualizar(Empleado empleadoActualizar) {
		Empleado empleadoActual = repositorio.findById(empleadoActualizar.getDNI()).get();
		empleadoActual.setDNI(empleadoActualizar.getDNI());
		empleadoActual.setNOMBRES(empleadoActualizar.getNOMBRES());
		empleadoActual.setAPELLIDOS(empleadoActualizar.getAPELLIDOS());
		empleadoActual.setDIRECCION(empleadoActualizar.getDIRECCION());
		empleadoActual.setSEXO(empleadoActualizar.getSEXO());
		empleadoActual.setEMAIL(empleadoActualizar.getEMAIL());
		empleadoActual.setTELEFONO(empleadoActualizar.getTELEFONO());
		
		
		
		Empleado empleadoActualizado = repositorio.save(empleadoActual);
		return empleadoActualizado;
	}

	public Empleado buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
