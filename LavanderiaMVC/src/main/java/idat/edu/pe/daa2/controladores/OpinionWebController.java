package idat.edu.pe.daa2.controladores;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import idat.edu.pe.daa2.jpa.modelo.Opinion;

import idat.edu.pe.daa2.jpa.servicios.OpinionServicio;


@Controller
@RequestMapping("/opinion")
public class OpinionWebController {
	
	@Autowired
	private OpinionServicio servicio;
	
	
	
	@RequestMapping("/principal")
	public String listarOpinion(Model model) {
		List<Opinion> listaOpinion = servicio.buscarTodo();
		model.addAttribute("listaOpinion", listaOpinion);
		return "/ModuloOpinion/principal";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoOpinion(Model model) {
		Opinion opinion = new Opinion();
	
		
		model.addAttribute("opinion", opinion);
		
		return "/ModuloOpinion/calificacion";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearOpinion(@ModelAttribute("opinion") Opinion opinion) {
		servicio.crear(opinion);
		return "ModuloOpinion/mensaje";
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
