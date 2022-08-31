package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Departamento;
import idat.edu.pe.daa2.jpa.servicios.DepartamentoServicio;

@Controller
@RequestMapping("/departamento")
public class DepartamentoWebController {

	@Autowired
	private DepartamentoServicio servicio;





	@RequestMapping("/principal")
	public String listarDepartamento(Model model) {
		List<Departamento> listaDepartamento = servicio.buscarTodo();
		model.addAttribute("listaDepartamento", listaDepartamento);
		return "/ModuloDepartamento/principal";
	}

	@RequestMapping("/nuevo")

		public String nuevoDepartamento(Model model) {
			Departamento departamento = new Departamento();
			model.addAttribute("departamento", departamento);
			return "/ModuloDepartamento/registrar";
	}



	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearDepartamento(@ModelAttribute("departamento") Departamento departamento) {
		servicio.crear(departamento);
		return "ModuloDepartamento/mensaje";
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



