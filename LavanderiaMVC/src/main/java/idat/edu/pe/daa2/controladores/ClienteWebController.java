package idat.edu.pe.daa2.controladores;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
/*
import org.springframework.web.bind.annotation.PathVariable;
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
import org.springframework.web.servlet.ModelAndView;
*/
import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.modelo.Distrito;

import idat.edu.pe.daa2.jpa.servicios.ClienteServicio;
import idat.edu.pe.daa2.jpa.servicios.DistritoServicio;


@Controller
@RequestMapping("/cliente")
public class ClienteWebController {
	
	@Autowired
	private ClienteServicio servicio;
	
	@Autowired
	private DistritoServicio servicioDistrito;
	
	

	@RequestMapping("/principal")
	public String listarCliente(Model model) {
		List<Cliente> listaCliente = servicio.buscarTodo();
		model.addAttribute("listaCliente", listaCliente);
		return "/ModuloCliente/principal";
	}

	@RequestMapping("/nuevo")
	public String nuevoCliente(Model model) {
		Cliente cliente = new Cliente();
		List<Distrito> listDistrito = servicioDistrito.buscarTodo();
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("distrito", listDistrito);
		
		return "/ModuloCliente/registrar";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		servicio.crear(cliente);
		
			return "ModuloCliente/mensaje";
		
		
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
