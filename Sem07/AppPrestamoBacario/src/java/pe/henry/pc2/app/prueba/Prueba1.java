package pe.henry.pc2.app.prueba;

import pe.henry.pc2.app.model.CuotaModel;
import pe.henry.pc2.app.model.PrestamoModel;
import pe.henry.pc2.app.service.BancoService;


public class Prueba1 {
    public static void main(String[] args) {
         //Datos
        double capital = 1000.0;
        double interes = 4;
        int meses = 12;
        
        //Proceso
        BancoService service = new BancoService();
        PrestamoModel model = service.procesar(meses, capital, interes);

        // Reporte
        System.out.println("Importe mensual: " + model.getValorCuota());
        System.out.println("Monto Solicitado: " + model.getCapital());
        System.out.println("Total interes: " + model.getTotalInteres());
        System.out.println("Total a pagar "+model.getImportePagar());
        
        for (CuotaModel r : model.getCuotas()) {
          System.out.println(r.toString());
        }
    }
}
