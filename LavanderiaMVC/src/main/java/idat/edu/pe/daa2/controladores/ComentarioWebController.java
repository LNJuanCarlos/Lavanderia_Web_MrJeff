package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Comentario;
import idat.edu.pe.daa2.jpa.servicios.ComentarioServicio;

@Controller
@RequestMapping("/comentario")
public class ComentarioWebController {

	@Autowired
	private ComentarioServicio servicio;





	@RequestMapping("/principal")
	public String listarComentario(Model model) {
		List<Comentario> listaComentario = servicio.buscarTodo();
		model.addAttribute("listaComentario", listaComentario);
		return "/ModuloComentario/principal";
	}

	@RequestMapping("/nuevo")

		public String nuevoComentario(Model model) {
			Comentario comentario = new Comentario();
			model.addAttribute("comentario", comentario);
			return "/ModuloComentario/registrar";
	}



	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearComentario(@ModelAttribute("comentario") Comentario comentario) {
		servicio.crear(comentario);
		return "ModuloComentario/mensaje";
	}
	/*
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarCliente(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/ModuloCliente/actualizar");
		Cliente cliente = servicio.buscarPorID(id);
		mav.addObject("cliente", cliente);

		return mav;
	}
	*/
	/*
	@RequestMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable(name = "id") String id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/cliente/mensaje";
	}

	*/
	}




