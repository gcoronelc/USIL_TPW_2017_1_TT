package pe.henry.app.prueba;

import pe.henry.app.model.VentaModel;
import pe.henry.app.service.VentaService;

public class Prueba01 {

    public static void main(String[] args) {
        //datos
        VentaModel model = new VentaModel("pantalon", 1000, 50000, 25.0,200.00);
        //proceso
        VentaService service = new VentaService();
        model = service.procesar(model);
        //reporte
        System.out.println("producto: " + model.getNombre());
        System.out.println("unidades comerciales: " + model.getTocantidad());
        System.out.println("Costo Total de Lote: " + model.getCostotal());
        System.out.println("Costo por Unidad: " + model.getCostunid());
        System.out.println("Precio de venta: " + model.getPreventa());

    }
}
