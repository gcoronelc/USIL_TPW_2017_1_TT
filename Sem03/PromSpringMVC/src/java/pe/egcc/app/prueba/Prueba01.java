package pe.egcc.app.prueba;

import pe.egcc.app.model.PromModel;
import pe.egcc.app.service.PromService;


public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    PromModel model = new PromModel(18, 10, 17);
    // Proceso
    PromService service = new PromService();
    model = service.procesar(model);
    // Reporte
    System.out.println("Prom. Final: " + model.getPromFinal());
    System.out.println("Estado: " + model.getEstado());
  }
  
}
