package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Pago;
import idat.edu.pe.daa2.jpa.repositorios.PagoRepositorio;

@Service
@Transactional
public class PagoServicio {
	
	@Autowired
	private PagoRepositorio repositorio;

	public PagoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Pago> buscarTodo() {
		return (List<Pago>) repositorio.findAll();  
	}

	public Pago crear(Pago pago) {
		return repositorio.save(pago);
	}

	public Pago actualizar(Pago pagoActualizar) {
		Pago pagoActual = repositorio.findById(pagoActualizar.getID_PAGO()).get();
		pagoActual.setID_PAGO(pagoActualizar.getID_PAGO());
		pagoActual.setDESCRIPCION_PAGO(pagoActualizar.getDESCRIPCION_PAGO());
		pagoActual.setMONTO_TOTAL(pagoActualizar.getMONTO_TOTAL());
		pagoActual.setTIPO_PAGO(pagoActualizar.getTIPO_PAGO());
		pagoActual.setESTADO(pagoActualizar.getESTADO());
	
		
		
		
		Pago pagoActualizado = repositorio.save(pagoActual);
		return pagoActualizado;
	}

	public Pago buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
