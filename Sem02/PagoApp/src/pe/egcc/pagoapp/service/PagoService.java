package pe.egcc.pagoapp.service;

import pe.egcc.pagoapp.dto.PagoDto;

public class PagoService {


  public PagoDto procesar(PagoDto dto){
    // Variables
    double ingreso, renta, neto;
    // Proceso
    ingreso = dto.getHorasDia() * dto.getDias() * dto.getPagoHora();
    renta = 0.0;
    if(ingreso > 1500.00){
      renta = ingreso * 0.08;
    }
    neto = ingreso - renta;
    // Output
    dto.setIngreso(ingreso);
    dto.setRenta(renta);
    dto.setNeto(neto);
    return dto;
  }
  
}
