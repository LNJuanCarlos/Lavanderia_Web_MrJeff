package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.modelo.Tipo_Pago;
import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.modelo.Pago;
import idat.edu.pe.daa2.jpa.modelo.Pedido;
import idat.edu.pe.daa2.jpa.servicios.ProductoServicio;
import idat.edu.pe.daa2.jpa.servicios.Tipo_PagoServicio;
import idat.edu.pe.daa2.jpa.servicios.ClienteServicio;
import idat.edu.pe.daa2.jpa.servicios.PagoServicio;
import idat.edu.pe.daa2.jpa.servicios.PedidoServicio;

@Controller
@RequestMapping("/pago")
public class PagoWebController {

	@Autowired
	private PagoServicio servicio;
	
	@Autowired
	private ClienteServicio servicioCliente;
	
	@Autowired
	private PedidoServicio servicioPedido;
	
	@Autowired
	private ProductoServicio servicioProducto;
	
	@Autowired
	private Tipo_PagoServicio servicioTipo_Pago;
	

	@RequestMapping("/principal")
	public String listarPago(Model model) {
		List<Pago> listaPago = servicio.buscarTodo();
		model.addAttribute("listaPago", listaPago);
		return "/ModuloPago/principal";
	}

	@RequestMapping("/nuevo")
	public String nuevoPago(Model model) {
		Pago pago = new Pago();
		List<Cliente> listCliente = servicioCliente.buscarTodo();
		List<Pedido> listPedido = servicioPedido.buscarTodo();
		List<Producto> listProducto = servicioProducto.buscarTodo();
		List<Tipo_Pago> listTipo_Pago = servicioTipo_Pago.buscarTodo();
		
		model.addAttribute("pago", pago);
		model.addAttribute("cliente", listCliente);
		model.addAttribute("pedido", listPedido);
		model.addAttribute("producto", listProducto);
		model.addAttribute("tipo_pago", listTipo_Pago);
		
		return "/ModuloPago/registrar";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPago(@ModelAttribute("pago") Pago pago) {
		servicio.crear(pago);
		return "ModuloPago/mensaje";
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


