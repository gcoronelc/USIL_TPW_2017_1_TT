package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"lista","nombre"})
public class AppController {

  @RequestMapping(value = "/")
  public String home(Model model) {
    // Inicializar las variables de session
    List<String> lista = new ArrayList<>();
    lista.add("CHICLAYO");
    lista.add("PIURA");
    lista.add("PACHERRES");
    model.addAttribute("lista", lista);
    model.addAttribute("nombre", "Gustavo Coronel");
    // Cargar el index.jsp    
    return "index";
  }

  @RequestMapping(value = "/agregar.usil", method = RequestMethod.GET)
  public String agregar() {
    return "agregar";
  }

  @RequestMapping(value = "/agregar.usil", method = RequestMethod.POST)
  public String agregar(
          @RequestParam("ciudad") String ciudad,
          @ModelAttribute("lista") List<String> lista,
          Model model
  ) {
    // Agregar ciudad a la lista
    if (!ciudad.isEmpty()) {
      lista.add(ciudad);
      // Retornando un mensaje
      model.addAttribute("mensaje", "Ciudad " + ciudad + " ya está en lista.");
    }
    return "agregar";
  }

  @RequestMapping(value = "/listado.usil", method = RequestMethod.GET)
  public String listado() {
    return "listado";
  }

  @RequestMapping(value = "/limpiar.usil", method = RequestMethod.GET)
  public String limpiar(SessionStatus sessionStatus) {
    // Limpiar la session
    sessionStatus.setComplete();
    // Forward
    return "redirect:/";
  }

  @RequestMapping(value = "/delete.usil", method = RequestMethod.GET)
  public String deleteItem(
          @RequestParam("ciudad") String ciudad,
          @ModelAttribute("lista") List<String> lista) {
    // Eliminar elemento
    lista.remove(ciudad);
    // Forward
    return "listado";
  }

}
