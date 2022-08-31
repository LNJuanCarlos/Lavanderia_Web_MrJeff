package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Detalle_Pedido;
import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.servicios.Detalle_PedidoServicio;
import idat.edu.pe.daa2.jpa.servicios.ProductoServicio;

@Controller
@RequestMapping("/detalle_pedido")
public class Detalle_PedidoWebController {

	@Autowired
	private Detalle_PedidoServicio servicio;
	
	@Autowired
	private ProductoServicio servicioProducto;
	
	

	@RequestMapping("/principal")
	public String listarDetalle_Pedido(Model model) {
		List<Detalle_Pedido> listaDetalle_Pedido = servicio.buscarTodo();
		model.addAttribute("listaDetalle_Pedido", listaDetalle_Pedido);
		return "/ModuloDetalle_Pedido/principal";
	}

	@RequestMapping("/nuevo")
	public String nuevoDetalle_Pedido(Model model) {
		Detalle_Pedido detalle_pedido = new Detalle_Pedido();
		List<Producto> listProducto = servicioProducto.buscarTodo();
		
		model.addAttribute("detalle_pedido", detalle_pedido);
		model.addAttribute("producto", listProducto);
		
		return "/ModuloDetalle_Pedido/registrar";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearDetalle_Pedido(@ModelAttribute("detalle_pedido") Detalle_Pedido detalle_pedido) {
		servicio.crear(detalle_pedido);
		return "ModuloDetalle_Pedido/mensaje";
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

