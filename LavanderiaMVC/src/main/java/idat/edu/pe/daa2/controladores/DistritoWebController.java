package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.modelo.Departamento;
import idat.edu.pe.daa2.jpa.servicios.DistritoServicio;
import idat.edu.pe.daa2.jpa.servicios.DepartamentoServicio;

@Controller
@RequestMapping("/distrito")
public class DistritoWebController {

	@Autowired
	private DistritoServicio servicio;
	
	@Autowired
	private DepartamentoServicio servicioDepartamento;
	
	

	@RequestMapping("/principal")
	public String listarDistrito(Model model) {
		List<Distrito> listaDistrito = servicio.buscarTodo();
		model.addAttribute("listaDistrito", listaDistrito);
		return "/ModuloDistrito/principal";
	}

	@RequestMapping("/nuevo")
	public String nuevoDistrito(Model model) {
		Distrito distrito = new Distrito();
		List<Departamento> listDepartamento = servicioDepartamento.buscarTodo();
		
		model.addAttribute("distrito", distrito);
		model.addAttribute("departamento", listDepartamento);
		
		return "/ModuloDistrito/registrar";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearDistrito(@ModelAttribute("distrito") Distrito distrito) {
		servicio.crear(distrito);
		return "ModuloDistrito/mensaje";
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

