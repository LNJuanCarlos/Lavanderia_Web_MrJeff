package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Pedido;
import idat.edu.pe.daa2.jpa.repositorios.PedidoRepositorio;

@Service
@Transactional
public class PedidoServicio {
	
	@Autowired
	private PedidoRepositorio repositorio;

	public PedidoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Pedido> buscarTodo() {
		return (List<Pedido>) repositorio.findAll();  
	}

	public Pedido crear(Pedido pedido) {
		return repositorio.save(pedido);
	}

	public Pedido actualizar(Pedido pedidoActualizar) {
		Pedido pedidoActual = repositorio.findById(pedidoActualizar.getID_PEDIDO()).get();
		pedidoActual.setID_PEDIDO(pedidoActualizar.getID_PEDIDO());
		pedidoActual.setFEC_PEDIDO(pedidoActualizar.getFEC_PEDIDO());
		
	
		
		
		
		Pedido pedidoActualizado = repositorio.save(pedidoActual);
		return pedidoActualizado;
	}

	public Pedido buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
