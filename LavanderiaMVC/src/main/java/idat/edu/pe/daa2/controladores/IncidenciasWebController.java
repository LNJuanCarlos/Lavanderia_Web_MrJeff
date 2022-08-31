package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.modelo.Comentario;
import idat.edu.pe.daa2.jpa.modelo.Incidencias;
import idat.edu.pe.daa2.jpa.modelo.Opinion;
import idat.edu.pe.daa2.jpa.modelo.Pedido;
import idat.edu.pe.daa2.jpa.servicios.IncidenciasServicio;
import idat.edu.pe.daa2.jpa.servicios.OpinionServicio;
import idat.edu.pe.daa2.jpa.servicios.PedidoServicio;
import idat.edu.pe.daa2.jpa.servicios.ClienteServicio;
import idat.edu.pe.daa2.jpa.servicios.ComentarioServicio;


@Controller
@RequestMapping("/incidencias")
public class IncidenciasWebController {
	
	@Autowired
	private IncidenciasServicio servicio;
	
	@Autowired
	private ClienteServicio servicioCliente;
	
	@Autowired
	private PedidoServicio servicioPedido;
	
	@Autowired
	private OpinionServicio servicioOpinion;
	
	@Autowired
	private ComentarioServicio servicioComentario;
	
	@RequestMapping("/principal")
	public String listarIncidencias(Model model) {
		List<Incidencias> listaIncidencias = servicio.buscarTodo();
		model.addAttribute("listaIncidencias", listaIncidencias);
		return "/ModuloIncidencias/principal";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoIncidencias(Model model) {
		Incidencias incidencias = new Incidencias();
		List<Cliente> listCliente = servicioCliente.buscarTodo();
		List<Pedido> listPedido = servicioPedido.buscarTodo();
		List<Opinion> listOpinion = servicioOpinion.buscarTodo();
		List<Comentario> listComentario = servicioComentario.buscarTodo();
		
		model.addAttribute("incidencias", incidencias);
		model.addAttribute("cliente", listCliente);
		model.addAttribute("pedido", listPedido);
		model.addAttribute("opinion", listOpinion);
		model.addAttribute("comentario", listComentario);
		
		return "/ModuloIncidencias/incidencias";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearIncidencias(@ModelAttribute("incidencias") Incidencias incidencias) {
		servicio.crear(incidencias);
		return "ModuloIncidencias/mensaje";
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
