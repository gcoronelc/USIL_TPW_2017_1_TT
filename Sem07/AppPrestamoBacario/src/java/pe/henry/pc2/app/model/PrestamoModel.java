package pe.henry.pc2.app.model;

import java.util.List;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class PrestamoModel {
  
  private double valorCuota;
  private double importePagar;
  private double totalInteres;
  private double capital;
  private List<CuotaModel> cuotas;

  public PrestamoModel() {
  }

  public PrestamoModel(double valorCuota, double importePagar, double totalInteres, double capital) {
    this.valorCuota = valorCuota;
    this.importePagar = importePagar;
    this.totalInteres = totalInteres;
    this.capital = capital;
  }

  public PrestamoModel(double valorCuota, double importePagar, double totalInteres, double capital, List<CuotaModel> cuotas) {
    this.valorCuota = valorCuota;
    this.importePagar = importePagar;
    this.totalInteres = totalInteres;
    this.capital = capital;
    this.cuotas = cuotas;
  }

  public double getValorCuota() {
    return valorCuota;
  }

  public void setValorCuota(double valorCuota) {
    this.valorCuota = valorCuota;
  }

  public double getImportePagar() {
    return importePagar;
  }

  public void setImportePagar(double importePagar) {
    this.importePagar = importePagar;
  }

  public double getTotalInteres() {
    return totalInteres;
  }

  public void setTotalInteres(double totalInteres) {
    this.totalInteres = totalInteres;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public List<CuotaModel> getCuotas() {
    return cuotas;
  }

  public void setCuotas(List<CuotaModel> cuotas) {
    this.cuotas = cuotas;
  }

  
  
  

}
