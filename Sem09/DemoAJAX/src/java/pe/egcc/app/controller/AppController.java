package pe.egcc.app.controller;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
@Controller
public class AppController {

  @RequestMapping(value = "index.htm", method = RequestMethod.GET)
  public String home(){
    return "index";
  }
  
  @RequestMapping(value = "/pagina1.htm", method = RequestMethod.GET)
  public String pagina1(){
    return "pagina1";
  }
  
  @RequestMapping(value = "/sumar.htm", 
          method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public String pagina1(
          @RequestParam("num1") int n1,
          @RequestParam("num2") int n2
  ){
    // Proceso
    int suma = n1 + n2;
    // Reporte
    Map<String,Object> repo = new HashMap<>();
    repo.put("n1", n1);
    repo.put("n2", n2);
    repo.put("su", suma);
    // Creando el texto JSON
    Gson gson = new Gson();
    String repoJSON = gson.toJson(repo);
    return repoJSON;
  }

  
  @RequestMapping(value = "/pagina2.htm", method = RequestMethod.GET)
  public String pagina2(){
    return "pagina2";
  }
  
}
