package pe.egcc.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.egcc.app.model.PromModel;
import pe.egcc.app.service.PromService;

@Controller
public class AppController {
  
  @Autowired
  private PromService promService;
  
  @RequestMapping(value = "/")
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "/panchito.usil", method = RequestMethod.POST)
  public String procesar(HttpServletRequest request, Model model){
    // Datos
    PromModel pm = new PromModel();
    pm.setPromPract(Double.parseDouble(request.getParameter("pp")));
    pm.setExaParcial(Double.parseDouble(request.getParameter("ep")));
    pm.setExaFinal(Double.parseDouble(request.getParameter("ef")));
    // Proceso
    pm = promService.procesar(pm);
    // Reporte
    model.addAttribute("alumno", pm);
    return "index";
  }
}
