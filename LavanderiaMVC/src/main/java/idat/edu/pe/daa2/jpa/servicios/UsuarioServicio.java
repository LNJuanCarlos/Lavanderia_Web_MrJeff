package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Usuario;
import idat.edu.pe.daa2.jpa.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;

	public UsuarioServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> buscarTodo() {
		return (List<Usuario>) repositorio.findAll();  
	}

	public Usuario crear(Usuario usuario) {
		return repositorio.save(usuario);
	}

	public Usuario actualizar(Usuario usuarioActualizar) {
		Usuario usuarioActual = repositorio.findById(usuarioActualizar.getID_USUARIO()).get();
		usuarioActual.setID_USUARIO(usuarioActualizar.getID_USUARIO());
		usuarioActual.setNOM_USUARIO(usuarioActualizar.getNOM_USUARIO());
		usuarioActual.setPASSWORD(usuarioActualizar.getPASSWORD());
		usuarioActual.setESTADO(usuarioActualizar.getESTADO());
		
		
		
		
		
		Usuario usuarioActualizado = repositorio.save(usuarioActual);
		return usuarioActualizado;
	}

	public Usuario buscarPorID(String id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(String id) {
		repositorio.deleteById(id);
	}

}
