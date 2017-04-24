package pe.humberto.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.humberto.app.model.VentaModel;
import pe.humberto.app.service.VentaService;

@Controller
public class VentaController {

  @Autowired
  private VentaService ventaService;

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/panchito.usil", method = RequestMethod.POST)
  public String procesar(HttpServletRequest request, Model model) {
    
    //datos
    VentaModel vm = new VentaModel();
    vm.setProducto(request.getParameter("producto"));
    vm.setTamLote(Integer.parseInt(request.getParameter("tamLote")));
    vm.setPrecLote(Double.parseDouble(request.getParameter("precLote")));
    vm.setPorcGastos(Integer.parseInt(request.getParameter("porcGastos")));
    vm.setPorcGanancia(Integer.parseInt(request.getParameter("porcGanancia")));
       
    // Proceso
    ventaService.procesar(vm);
    
    // Reporte
    model.addAttribute("venta", vm);
    return "index";

  }
}
