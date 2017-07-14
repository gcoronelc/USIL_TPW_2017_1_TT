package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.CuentaService;
import pe.egcc.eureka.service.EmpleadoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Controller
@SessionAttributes(value = { "empSession", "usuSession", "permisos" })
public class AppController {

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private EmpleadoService empleadoService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home1(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "index";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String home2(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "index";
	}

	@RequestMapping(value = "/logon.htm", method = RequestMethod.POST)
	public String logon(
		@RequestParam("usuario") String usuario,
		@RequestParam("clave") String clave,
		Model model) {

		String destino;	
		try {
			
			// Proceso
			Empleado bean = empleadoService.validar(usuario, clave);
			if(bean ==  null){
				throw new Exception("Datos incorrectos");
			}
			destino = "main";
			model.addAttribute("empSession", bean);
			model.addAttribute("usuSession", usuario);
			
			// Cargar permisos
			model.addAttribute("permisos", 
					empleadoService.leerPermisos(bean.getCodigo()));
			
		} catch (Exception e) {

			destino = "index";
			model.addAttribute("error", e.getMessage());
			
		}
		
		return destino;
	}

	@RequestMapping(value = "/generales.htm", method = RequestMethod.GET)
	public String generales(Model model) {

		model.addAttribute("menuGenerales", "id='current'");

		model.addAttribute("cantCuentas", cuentaService.getCantCuentas());
		model.addAttribute("saldoSoles", cuentaService.getSaldoTotal("01"));
		model.addAttribute("saldoDolares", cuentaService.getSaldoTotal("02"));

		return "generales";
	}

}
