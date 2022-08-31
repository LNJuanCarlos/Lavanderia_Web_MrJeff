package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Empleado;
import idat.edu.pe.daa2.jpa.modelo.Usuario;
import idat.edu.pe.daa2.jpa.modelo.Cargo;
import idat.edu.pe.daa2.jpa.modelo.Distrito;
import idat.edu.pe.daa2.jpa.servicios.EmpleadoServicio;
import idat.edu.pe.daa2.jpa.servicios.UsuarioServicio;
import idat.edu.pe.daa2.jpa.servicios.CargoServicio;
import idat.edu.pe.daa2.jpa.servicios.DistritoServicio;

@Controller
@RequestMapping("/empleado")
public class EmpleadoWebController {

	@Autowired
	private EmpleadoServicio servicio;
	
	@Autowired
	private DistritoServicio servicioDistrito;
	
	@Autowired
	private UsuarioServicio servicioUsuario;
	
	@Autowired
	private CargoServicio servicioCargo;
	

	@RequestMapping("/principal")
	public String listarEmpleado(Model model) {
		List<Empleado> listaEmpleado = servicio.buscarTodo();
		model.addAttribute("listaEmpleado", listaEmpleado);
		return "/ModuloEmpleado/principal";
	}

	@RequestMapping("/nuevo")
	public String nuevoEmpleado(Model model) {
		Empleado empleado = new Empleado();
		List<Distrito> listDistrito = servicioDistrito.buscarTodo();
		List<Usuario> listUsuario = servicioUsuario.buscarTodo();
		List<Cargo> listCargo = servicioCargo.buscarTodo();
		
		model.addAttribute("empleado", empleado);
		model.addAttribute("distrito", listDistrito);
		model.addAttribute("usuario", listUsuario);
		model.addAttribute("cargo", listCargo);
		
		return "/ModuloEmpleado/registrar";
	}
	
	

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		servicio.crear(empleado);
		return "ModuloEmpleado/mensaje";
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

