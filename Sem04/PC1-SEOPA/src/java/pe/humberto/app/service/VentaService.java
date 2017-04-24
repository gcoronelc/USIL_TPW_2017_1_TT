package pe.humberto.app.service;

import org.springframework.stereotype.Service;
import pe.humberto.app.model.VentaModel;

@Service
public class VentaService {

  public VentaModel procesar(VentaModel model) {
    
    // variables
    int uniComerc;
    double costoTotal;
    double costoUnidad;
    double precVentaUni;

    // Proceso
    uniComerc = (int) (model.getTamLote() * 0.90);
    costoTotal = model.getPrecLote()
            + model.getPrecLote() * model.getPorcGastos() / 100;
    costoUnidad = costoTotal / uniComerc;
    precVentaUni = costoUnidad + costoUnidad * model.getPorcGanancia() / 100;

    //repotte
    model.setUniComerc(uniComerc);
    model.setCostoTotal(costoTotal);
    model.setCostoUnidad(costoUnidad);
    model.setPrecVentaUni(precVentaUni);
    return model;
  }
}
