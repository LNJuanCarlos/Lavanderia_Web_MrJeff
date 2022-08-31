package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Cargo;
import idat.edu.pe.daa2.jpa.repositorios.CargoRepositorio;

@Service
@Transactional
public class CargoServicio {
	
	@Autowired
	private CargoRepositorio repositorio;

	public CargoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Cargo> buscarTodo() {
		return (List<Cargo>) repositorio.findAll();  
	}

	public Cargo crear(Cargo cargo) {
		return repositorio.save(cargo);
	}

	public Cargo actualizar(Cargo cargoActualizar) {
		Cargo cargoActual = repositorio.findById(cargoActualizar.getID_CARGO()).get();
		cargoActual.setID_CARGO(cargoActualizar.getID_CARGO());
		cargoActual.setNOMBRE_CARGO(cargoActualizar.getNOMBRE_CARGO());
		cargoActual.setSUELDO(cargoActualizar.getSUELDO());
	
		
		
		
		Cargo cargoActualizado = repositorio.save(cargoActual);
		return cargoActualizado;
	}

	public Cargo buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
