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

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.modelo.Categoria;
import idat.edu.pe.daa2.jpa.servicios.ProductoServicio;
import idat.edu.pe.daa2.jpa.servicios.CategoriaServicio;

@Controller
@RequestMapping("/producto")
public class ProductoWebController {
	
	@Autowired
	private ProductoServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCategoria;
	
	
	@RequestMapping("/principal")
	public String listarProducto(Model model) {
		List<Producto> listaProducto = servicio.buscarTodo();
		model.addAttribute("listaProducto", listaProducto);
		return "/ModuloProducto/principal";
	}


	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Producto producto = new Producto();
		List<Categoria> listCategoria = servicioCategoria.buscarTodo();
		
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", listCategoria);
		
		return "/ModuloProducto/nuevo";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("producto") Producto producto) {
		servicio.crear(producto);
		return "ModuloProducto/mensaje";
	}

	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarProducto(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("/ModuloProducto/actualizar");
		Producto producto = servicio.buscarPorID(id);
		mav.addObject("producto", producto);

		return mav;
	}

	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(name = "id") String id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/producto/mensaje";
	}


}

