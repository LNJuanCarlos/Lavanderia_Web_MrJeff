package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Tipo_Pago;
import idat.edu.pe.daa2.jpa.repositorios.Tipo_PagoRepositorio;

@Service
@Transactional
public class Tipo_PagoServicio {
	
	@Autowired
	private Tipo_PagoRepositorio repositorio;

	public Tipo_PagoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Tipo_Pago> buscarTodo() {
		return (List<Tipo_Pago>) repositorio.findAll();  
	}

	public Tipo_Pago crear(Tipo_Pago tipo_pago) {
		return repositorio.save(tipo_pago);
	}

	public Tipo_Pago actualizar(Tipo_Pago tipo_pagoActualizar) {
		Tipo_Pago tipo_pagoActual = repositorio.findById(tipo_pagoActualizar.getID_TIPO_PAGO()).get();
		tipo_pagoActual.setID_TIPO_PAGO(tipo_pagoActualizar.getID_TIPO_PAGO());
		tipo_pagoActual.setDESC_TIPO_PAGO(tipo_pagoActualizar.getDESC_TIPO_PAGO());
		
		
	
		
		
		
		Tipo_Pago tipo_pagoActualizado = repositorio.save(tipo_pagoActual);
		return tipo_pagoActualizado;
	}

	public Tipo_Pago buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
