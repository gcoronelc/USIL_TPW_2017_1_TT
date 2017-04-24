package pe.egcc.app.service;

import org.springframework.stereotype.Service;
import pe.egcc.app.model.PromModel;

@Service
public class PromService {

  public PromModel procesar(PromModel model){
    // Variables
    double promFinal;
    String cond;
    // Proceso
    promFinal = (model.getPromPract() * 0.40 
            + model.getExaParcial() * 0.20 
            + model.getExaFinal() * 0.40);
    cond = "Aprobado";
    if(promFinal < 13.0){
      cond = "Desaprobado";
    }
    // Reporte
    model.setPromFinal(promFinal);
    model.setEstado(cond);
    return model;
  }
  
}
