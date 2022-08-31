package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Tipo_Pago;
import idat.edu.pe.daa2.jpa.servicios.Tipo_PagoServicio;

@Controller
@RequestMapping("/tipo_pago")
public class Tipo_PagoWebController {
	
	@Autowired
	private Tipo_PagoServicio servicio;





	@RequestMapping("/principal")
	public String listarTipo_Pago(Model model) {
		List<Tipo_Pago> listaTipo_Pago = servicio.buscarTodo();
		model.addAttribute("listaTipo_Pago", listaTipo_Pago);
		return "/ModuloTipo_Pago/principal";
	}

	@RequestMapping("/nuevo")

		public String nuevoTipo_Pago(Model model) {
		Tipo_Pago tipo_pago = new Tipo_Pago();
			model.addAttribute("tipo_pago", tipo_pago);
			return "/ModuloTipo_Pago/registrar";
	}



	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipo_Pago(@ModelAttribute("tipo_pago") Tipo_Pago tipo_pago) {
		servicio.crear(tipo_pago);
		return "ModuloTipo_Pago/mensaje";
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


