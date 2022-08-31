package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Detalle_Pedido;
import idat.edu.pe.daa2.jpa.repositorios.Detalle_PedidoRepositorio;

@Service
@Transactional
public class Detalle_PedidoServicio {
	
	@Autowired
	private Detalle_PedidoRepositorio repositorio;

	public Detalle_PedidoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Detalle_Pedido> buscarTodo() {
		return (List<Detalle_Pedido>) repositorio.findAll();  
	}

	public Detalle_Pedido crear(Detalle_Pedido detalle_pedido) {
		return repositorio.save(detalle_pedido);
	}

	public Detalle_Pedido actualizar(Detalle_Pedido detalle_pedidoActualizar) {
		Detalle_Pedido detalle_pedidoActual = repositorio.findById(detalle_pedidoActualizar.getID_DETALLE_PEDIDO()).get();
		detalle_pedidoActual.setID_DETALLE_PEDIDO(detalle_pedidoActualizar.getID_DETALLE_PEDIDO());
		detalle_pedidoActual.setDESC_PEDIDO(detalle_pedidoActualizar.getDESC_PEDIDO());
		detalle_pedidoActual.setCANTIDAD(detalle_pedidoActualizar.getCANTIDAD());
	
		
		
		
		Detalle_Pedido detalle_pedidoActualizado = repositorio.save(detalle_pedidoActual);
		return detalle_pedidoActualizado;
	}

	public Detalle_Pedido buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
