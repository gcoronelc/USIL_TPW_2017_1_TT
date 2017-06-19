package pe.egcc.eureka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.model.Cliente;
import pe.egcc.eureka.model.Combo;
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
  
}
