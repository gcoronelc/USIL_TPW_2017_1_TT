package pe.henry.app.service;

import org.springframework.stereotype.Service;
import pe.henry.app.model.VentaModel;

@Service
public class VentaService {

  public VentaModel procesar(VentaModel model) {
    //variables
    double tocantidad;
    double costotal;
    double cosunidad;
    double preventa;

    //proceso
    tocantidad = (model.getCantidad() * 0.9);
    costotal = ((model.getCosto() * (model.getGastoporcentaje() / 100)) + model.getCosto());
    cosunidad = costotal / tocantidad;
    preventa = (cosunidad * (model.getGanancia() / 100)) + cosunidad;

    //reporte
    model.setTocantidad(tocantidad);
    model.setCostotal(costotal);
    model.setCostunid(cosunidad);
    model.setPreventa(preventa);

    return model;
  }

}
