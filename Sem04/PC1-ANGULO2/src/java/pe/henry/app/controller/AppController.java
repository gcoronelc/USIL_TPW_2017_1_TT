package pe.henry.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.henry.app.model.VentaModel;
import pe.henry.app.service.VentaService;

@Controller
public class AppController {

  @Autowired
  private VentaService ventaService;

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/practica.usil", method = RequestMethod.POST)
  public String procesar(
          @RequestParam("txtCant") double cantidad, 
          @RequestParam("txtPrecio") double costo, 
          @RequestParam("txtGastos") double gastoporcentaje, 
          @RequestParam("txtPreventa") double ganancia, 
          Model model) {
    
    VentaModel vm = new VentaModel();
    vm.setCantidad(cantidad);
    vm.setCosto(costo);
    vm.setGastoporcentaje(gastoporcentaje);
    vm.setGanancia(ganancia);

    //Proceso
    vm = ventaService.procesar(vm);

    //reporte
    model.addAttribute("vm", vm);

    return "index";

  }
}
