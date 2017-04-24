package pe.henry.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
  public String procesar(HttpServletRequest request, Model model) {
    VentaModel vm = new VentaModel();
    vm.setCantidad(Double.parseDouble(request.getParameter("txtCant")));
    vm.setCosto(Double.parseDouble(request.getParameter("txtPrecio")));
    vm.setGastoporcentaje(Double.parseDouble(request.getParameter("txtGastos")));
    vm.setGanancia(Double.parseDouble(request.getParameter("txtPreventa")));

    //Proceso
    vm = ventaService.procesar(vm);

    //reporte
    model.addAttribute("vm", vm);

    return "index";

  }
}
