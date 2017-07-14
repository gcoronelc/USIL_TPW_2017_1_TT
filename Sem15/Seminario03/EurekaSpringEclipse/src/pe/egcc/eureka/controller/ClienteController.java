package pe.egcc.eureka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.model.Cliente;
import pe.egcc.eureka.model.Combo;
import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.ClienteService;
import pe.egcc.eureka.service.ComboService;
import pe.egcc.eureka.util.EurekaUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
@Controller
public class ClienteController {

  @Autowired
  private ClienteService  clienteService;
  
  @Autowired
  private ComboService comboService;
  
  
  @RequestMapping(value = "conClientes.htm", method=RequestMethod.GET )
  public String conClientes(Model model){
    
    model.addAttribute("menuConClientes", "menuItemActivo");
    
    
    return "conClientes";
    
  }
  
  @RequestMapping(value = "conClientes.htm", method=RequestMethod.POST )
  public String conClientes(
          @RequestParam("criterio") String criterio,
          Model model){
    
    
    List<Cliente> lista = clienteService.getClientes(criterio);
    
    model.addAttribute("menuConClientes", "menuItemActivo");
    model.addAttribute("lista", lista);
    
    return "conClientes";
    
  }
  
  @RequestMapping(value = "conClientes2.htm", method=RequestMethod.GET )
  public String conClientes2(Model model){
    
    // Proceso
    List<Combo> sucursales = comboService.getSucursales();
    
    // Reporte
    model.addAttribute("menuConClientes2", "menuItemActivo");
    model.addAttribute("sucursales", sucursales);
    
    
    return "conClientes2";
    
  }
  
  @RequestMapping(value = "conClientes2.htm", method=RequestMethod.POST )
  public String conClientes2(
          @RequestParam("sucursal") String sucursal,
          Model model){
    
    // Proceso
    List<Cliente> lista = clienteService.getClientesSucursal(sucursal);
    List<Combo> sucursales = comboService.getSucursales();
    
    EurekaUtil.selectedCombo(sucursales, sucursal);
    
    // Reporte
    
    model.addAttribute("menuConClientes2", "menuItemActivo");
    model.addAttribute("lista", lista);
    model.addAttribute("sucursales", sucursales);
    
    return "conClientes2";
    
  }
  
  // CRUD DE CLIENTES
  
  @RequestMapping(value="crudClientes.htm", method=RequestMethod.GET)
  public String crudClientes(Model model){

	  model.addAttribute("menuTablas", "id='current'");
	  
	  return "crudClientes";
  }
  
  
  @RequestMapping(value="crudClientesConsulta.htm", method=RequestMethod.POST)
  public String crudClientesConsulta(
		  @RequestParam("btnAccion") String accion,
		  @ModelAttribute Cliente bean,
		  Model model){

	  model.addAttribute("menuTablas", "id='current'");
	  
	  String destino = "crudClientes";
	  
	  if(accion.equals("Buscar")){
		  
		  List<Cliente> lista = clienteService.read(bean);
		  model.addAttribute("lista", lista);
		  destino = "crudClientes";
	  }
	  
	  if(accion.equals("Nuevo")){
		  
		  Cliente cliente = new Cliente();
		  cliente.setCodigo(EurekaUtil.CRUD_NUEVO);
		  model.addAttribute("cliente", cliente);
		  model.addAttribute("accion", EurekaUtil.CRUD_NUEVO);
		  destino = "crudClientesEditar";
		  
	  }
	 
	  return destino;
	  
  }
  
  
  @RequestMapping(value="crudClientesEditar.htm", method=RequestMethod.GET)
  public String crudClientesEditar(
		  @RequestParam("codigo") String codigo,
		  Model model){

	  // Proceso
	  Cliente bean = clienteService.read(codigo);
	  
	  // Reporte
	  model.addAttribute("cliente", bean);
	  model.addAttribute("accion", EurekaUtil.CRUD_EDITAR);
	  
	  return "crudClientesEditar";
  }
  
  @RequestMapping(value="crudClientesEliminar.htm", method=RequestMethod.GET)
  public String crudClientesEliminar(
		  @RequestParam("codigo") String codigo,
		  Model model){

	  // Proceso
	  Cliente bean = clienteService.read(codigo);
	  
	  // Reporte
	  model.addAttribute("cliente", bean);
	  model.addAttribute("disabled", "disabled");
	  model.addAttribute("accion", EurekaUtil.CRUD_ELIMINAR);
	  
	  return "crudClientesEditar";
  }
  
  @RequestMapping(value="crudClientesGrabar.htm", method=RequestMethod.POST)
  public String crudClientesGrabar(
		  @RequestParam("accion") String accion,
		  @ModelAttribute Cliente cliente,
		  Model model){

	String mensaje = "";
	try {
	
		switch (accion) {
		case EurekaUtil.CRUD_NUEVO:
			clienteService.crear(cliente);
			mensaje = "Cliente creado con codigo " + cliente.getCodigo() + ".";
			break;

		}
		
		model.addAttribute("mensaje", mensaje);
		
	} catch (Exception e) {
		
		model.addAttribute("error", e.getMessage());
		
	}
	 	  
	return "crudClientes";
  }
  
  
  
  
}
