package pe.humberto.app.prueba;

import pe.humberto.app.model.VentaModel;
import pe.humberto.app.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    VentaModel model = new VentaModel("Tequila", 1000, 50000.0, 25, 200);
    //preceso
    VentaService service = new VentaService();
    model = service.procesar(model);
    //reporte
    System.out.println("Uni. Comercializar: " + model.getUniComerc());
    System.out.println("Costo total del lote: " + model.getCostoTotal());
    System.out.println("costo por unidad: " + model.getCostoUnidad());
    System.out.println("Precio de Venta: " + model.getPrecVentaUni());
  }
}
/* model.setlotefinal(lotefinal);
   model.setpreciofinallote(preciofinallote);
   model.setcostounidad(costounidad);
   model.setprecioventaunidad(precioventaunidad);*/
