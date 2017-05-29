package pe.henry.pc2.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.henry.pc2.app.model.CuotaModel;
import pe.henry.pc2.app.model.PrestamoModel;

@Service
public class BancoService {

  public PrestamoModel procesar(int meses, double capital, double inteMensual) {
    // Datos totales
    double valorCuota;
    double importePagar;
    double totalInteres;
    // Datos Cuota
    int mes;
    double cuotaDeuda;
    double cuotaInteres;
    double cuotaCapital;
    double cuotaValor;
    // Proceso General
    double factInteres = inteMensual / 100;
    valorCuota = redondear(capital * (factInteres * (Math.pow((1 + factInteres), 12))) / ((Math.pow((1 + factInteres), meses)) - 1));
    importePagar = redondear(valorCuota * meses);
    totalInteres = redondear(importePagar - capital);
    // Proceso cuotas
    double saldo = capital;
    cuotaValor = valorCuota;
    List<CuotaModel> lista = new ArrayList<>();
    for (mes = 1; mes <= meses; mes++) {
      cuotaInteres = redondear(saldo * factInteres);
      cuotaCapital = redondear(cuotaValor - cuotaInteres);
      CuotaModel cuotaModel = new CuotaModel(mes, saldo, cuotaInteres, cuotaCapital, cuotaValor);
      lista.add(cuotaModel);
      saldo = redondear(saldo - cuotaCapital);
    }
    // Reporte
    PrestamoModel prestamoModel = new PrestamoModel();
    prestamoModel.setCapital(capital);
    prestamoModel.setImportePagar(importePagar);
    prestamoModel.setTotalInteres(totalInteres);
    prestamoModel.setValorCuota(valorCuota);
    prestamoModel.setCuotas(lista);
    return prestamoModel;
  }

  private double redondear(double valor) {
    valor *= 100.0;
    valor = Math.round(valor);
    valor /= 100;
    return valor;
  }
}
