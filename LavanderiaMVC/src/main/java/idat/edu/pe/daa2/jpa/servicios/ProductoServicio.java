package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.repositorios.ProductoRepositorio;

@Service
@Transactional
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio repositorio;

	public ProductoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Producto> buscarTodo() {
		return (List<Producto>) repositorio.findAll();  
	}

	public Producto crear(Producto producto) {
		return repositorio.save(producto);
	}

	public Producto actualizar(Producto productoActualizar) {
		Producto productoActual = repositorio.findById(productoActualizar.getID_PRODUCTO()).get();
		productoActual.setID_PRODUCTO(productoActualizar.getID_PRODUCTO());
		productoActual.setNOMBRE_PRODUCTO(productoActualizar.getNOMBRE_PRODUCTO());
		productoActual.setVALOR_UNITARIO(productoActualizar.getVALOR_UNITARIO());
		
	
		
		
		
		Producto productoActualizado = repositorio.save(productoActual);
		return productoActualizado;
	}

	public Producto buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}


}
