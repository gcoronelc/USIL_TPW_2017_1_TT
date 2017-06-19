package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.egcc.eureka.service.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
@Controller
public class AppController {
  
  @Autowired
  private CuentaService cuentaService;
  

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home1(){
    return "index";
  }
  
  @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
  public String home2(){
    return "index";
  }
  
  @RequestMapping(value = "/generales.htm", method = RequestMethod.GET)
  public String generales(Model model){
 
    model.addAttribute("menuGenerales", "menuItemActivo");
    
    model.addAttribute("cantCuentas", cuentaService.getCantCuentas());
    model.addAttribute("saldoSoles", cuentaService.getSaldoTotal("01"));
    model.addAttribute("saldoDolares", cuentaService.getSaldoTotal("02"));
    
    return "generales";
  }
  
  
  
}
