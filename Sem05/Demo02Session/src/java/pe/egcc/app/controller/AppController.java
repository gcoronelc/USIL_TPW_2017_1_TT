package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Scope("session")
public class AppController implements java.io.Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private List<String> lista = new ArrayList<>(); 

  @RequestMapping(value = "/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/agregar.usil", method = RequestMethod.GET)
  public String agregar() {
    return "agregar";
  }

  @RequestMapping(value = "/agregar.usil", method = RequestMethod.POST)
  public String agregar(
          @RequestParam("ciudad") String ciudad,
          Model model
  ) {
    // Agregar ciudad a la lista
    lista.add(ciudad);
    // Retornando un mensaje
    model.addAttribute("mensaje", "Ciudad " + ciudad + " ya está en lista.");
    return "agregar";
  }

  @RequestMapping(value = "/listado.usil", method = RequestMethod.GET)
  public String listado(Model model) {
    model.addAttribute("lista", lista);
    return "listado";
  }

  @RequestMapping(value = "/limpiar.usil", method = RequestMethod.GET)
  public String limpiar(Model model) {
    // Limpiar la session
    lista.clear();
    model.addAttribute("lista", lista);
    // Forward
    return "listado";
  }

  @RequestMapping(value = "/delete.usil", method = RequestMethod.GET)
  public String deleteItem(
          @RequestParam("ciudad") String ciudad,
          Model model) {
    // Eliminar elemento
    lista.remove(ciudad);
    model.addAttribute("lista", lista);
    // Forward
    return "listado";
  }

}
