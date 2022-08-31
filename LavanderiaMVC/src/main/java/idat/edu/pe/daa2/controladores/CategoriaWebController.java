package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Categoria;
import idat.edu.pe.daa2.jpa.servicios.CategoriaServicio;

@Controller
@RequestMapping("/categoria")
public class CategoriaWebController {

	@Autowired
	private CategoriaServicio servicio;





	@RequestMapping("/principal")
	public String listarCategoria(Model model) {
		List<Categoria> listaCategoria = servicio.buscarTodo();
		model.addAttribute("listaCategoria", listaCategoria);
		return "/ModuloCategoria/principal";
	}

	@RequestMapping("/nuevo")

		public String nuevoCategoria(Model model) {
			Categoria categoria = new Categoria();
			model.addAttribute("categoria", categoria);
			return "/ModuloCategoria/registrar";
	}



	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
		servicio.crear(categoria);
		return "ModuloCategoria/mensaje";
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



