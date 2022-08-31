package idat.edu.pe.daa2.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, String> {

}
