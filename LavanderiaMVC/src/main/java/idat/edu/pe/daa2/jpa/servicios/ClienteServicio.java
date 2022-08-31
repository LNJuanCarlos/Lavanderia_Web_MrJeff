package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.repositorios.ClienteRepositorio;

@Service
@Transactional
public class ClienteServicio {
	
	@Autowired
	private ClienteRepositorio repositorio;

	public ClienteServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Cliente> buscarTodo() {
		return (List<Cliente>) repositorio.findAll();  
	}

	public Cliente crear(Cliente cliente) {
		return repositorio.save(cliente);
	}

	public Cliente actualizar(Cliente clienteActualizar) {
		Cliente clienteActual = repositorio.findById(clienteActualizar.getDNI()).get();
		clienteActual.setDNI(clienteActualizar.getDNI());
		clienteActual.setNOMBRES(clienteActualizar.getNOMBRES());
		clienteActual.setAPELLIDOS(clienteActualizar.getAPELLIDOS());
		clienteActual.setDIRECCION(clienteActualizar.getDIRECCION());
		clienteActual.setSEXO(clienteActualizar.getSEXO());
		clienteActual.setEMAIL(clienteActualizar.getEMAIL());
		clienteActual.setTELEFONO(clienteActualizar.getTELEFONO());
	
		
		
		Cliente clienteActualizado = repositorio.save(clienteActual);
		return clienteActualizado;
	}

	public Cliente buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}


}
