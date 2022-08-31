package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Cargo;

import idat.edu.pe.daa2.jpa.servicios.CargoServicio;


@Controller
@RequestMapping("/cargo")
public class CargoWebController {

	

@Autowired
private CargoServicio servicio;





@RequestMapping("/principal")
public String listarCargo(Model model) {
	List<Cargo> listaCargo = servicio.buscarTodo();
	model.addAttribute("listaCargo", listaCargo);
	return "/ModuloCargo/principal";
}

@RequestMapping("/nuevo")

	public String nuevoCargo(Model model) {
		Cargo cargo = new Cargo();
		model.addAttribute("cargo", cargo);
		return "/ModuloCargo/registrar";
}



@RequestMapping(value = "/guardar", method = RequestMethod.POST)
public String crearCargo(@ModelAttribute("cargo") Cargo cargo) {
	servicio.crear(cargo);
	return "ModuloCargo/mensaje";
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

