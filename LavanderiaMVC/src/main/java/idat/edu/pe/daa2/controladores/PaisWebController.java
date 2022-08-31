package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Pais;
import idat.edu.pe.daa2.jpa.servicios.PaisServicio;

@Controller
@RequestMapping("/pais")
public class PaisWebController {
	
	@Autowired
	private PaisServicio servicio;





	@RequestMapping("/principal")
	public String listarPais(Model model) {
		List<Pais> listaPais = servicio.buscarTodo();
		model.addAttribute("listaPais", listaPais);
		return "/ModuloPais/principal";
	}

	@RequestMapping("/nuevo")

		public String nuevoPais(Model model) {
			Pais pais = new Pais();
			model.addAttribute("pais", pais);
			return "/ModuloPais/registrar";
	}



	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPais(@ModelAttribute("pais") Pais pais) {
		servicio.crear(pais);
		return "ModuloPais/mensaje";
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


