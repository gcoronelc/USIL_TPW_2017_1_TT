package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.service.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
@Controller
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;
  
  
  @RequestMapping(value = "resumenSucursal.htm", method = RequestMethod.GET)
  public String resumenSucursal(Model model){
    model.addAttribute("menuResumenSucursal", "menuItemActivo");
    return "resumenSucursal";
  }
  
  @RequestMapping(value = "resumenSucursal.htm", method = RequestMethod.POST)
  public String resumenSucursal(
          @RequestParam("sucursal") String sucursal,
          @RequestParam("moneda") String moneda,
          Model model){
    
    
    // Proceso
    List<Map<String,Object>> lista = cuentaService.getResumenSucursal(sucursal, moneda);
    model.addAttribute("lista", lista);
    model.addAttribute("menuResumenSucursal", "menuItemActivo");
    
    return "resumenSucursal";
  }
  
  
  
  
  
}
