package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Pedido;
import idat.edu.pe.daa2.jpa.servicios.PedidoServicio;

@Controller
@RequestMapping("/pedido")
public class PedidoWebController {
	
	@Autowired
	private PedidoServicio servicio;
	
	

	@RequestMapping("/listarTodo")
	public String listarPedido(Model model) {
		List<Pedido> listaPedido = servicio.buscarTodo();
		model.addAttribute("listaPedido", listaPedido);
		return "/ModuloPedido/pedido";
	}

	@RequestMapping("/nuevo")
	public String nuevoPedido(Model model) {
		Pedido pedido = new Pedido();
		
		model.addAttribute("pedido", pedido);

		return "/ModuloPedido/ListaPedido";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPedido(@ModelAttribute("pedido") Pedido pedido) {
		servicio.crear(pedido);
		return "/ModuloPedido/mensaje";
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
