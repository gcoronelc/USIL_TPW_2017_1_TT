package pe.egcc.appsuma.prueba;

import pe.egcc.appsuma.service.MateService;

public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    int n1 = 78;
    int n2 = 57;
    // Proceso
    MateService service = new MateService();
    int suma = service.sumar(n1, n2);
    // Reporte
    System.out.println("n1: " + n1);
    System.out.println("n2: " + n2);
    System.out.println("Suma: " + suma);
  }
  
}
