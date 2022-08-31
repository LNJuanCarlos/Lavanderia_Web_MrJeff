package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Usuario;
import idat.edu.pe.daa2.jpa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioWebController {

	@Autowired
	private UsuarioServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarUsuario(Model model) {
		List<Usuario> listaUsuario = servicio.buscarTodo();
		model.addAttribute("listaUsuario", listaUsuario);
		return "/ModuloUsuario/listarTodo";
	}

	@RequestMapping("/nuevo")
	public String nuevoUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "/ModuloUsuario/registrar";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
		servicio.crear(usuario);
		return "redirect:/usuario/listarTodo";
	}

	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarUsuario(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/ModuloUsuario/actualizar");
		Usuario usuario = servicio.buscarPorID(id);
		mav.addObject("usuario", usuario);

		return mav;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") String id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/usuario/listarTodo";
	}

}
