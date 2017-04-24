package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

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
          HttpSession session,
          Model model
  ) {
    // Accediendo a la lista
    List<String> lista;
    if (session.getAttribute("lista") == null) {
      lista = new ArrayList<>();
      session.setAttribute("lista", lista);
    } else {
      lista = (List<String>) session.getAttribute("lista");
    }
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
  public String limpiar(HttpSession session) {
    // Limpiar la session
    session.invalidate();
    // Forward
    return "listado";
  }

  @RequestMapping(value = "/delete.usil", method = RequestMethod.GET)
  public String deleteItem(
          @RequestParam("ciudad") String ciudad,
          HttpSession session) {
    // Accediendo a la lista
    List<String> lista;
    if (session.getAttribute("lista") == null) {
      lista = new ArrayList<>();
      session.setAttribute("lista", lista);
    } else {
      lista = (List<String>) session.getAttribute("lista");
    }
    // Eliminar elemento
    lista.remove(ciudad);
    // Forward
    return "listado";
  }

}
