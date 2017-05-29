package pe.henry.pc2.app.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class CuotaModel {

  private int mes;
  private double deuda;
  private double interes;
  private double capital;
  private double cuota;

  public CuotaModel() {
  }

  public CuotaModel(int mes, double deuda, double interes, double capital, double cuota) {
    this.mes = mes;
    this.deuda = deuda;
    this.interes = interes;
    this.capital = capital;
    this.cuota = cuota;
  }

  

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public double getDeuda() {
    return deuda;
  }

  public void setDeuda(double deuda) {
    this.deuda = deuda;
  }

  public double getInteres() {
    return interes;
  }

  public void setInteres(double interes) {
    this.interes = interes;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public double getCuota() {
    return cuota;
  }

  public void setCuota(double cuota) {
    this.cuota = cuota;
  }

  @Override
  public String toString() {
    String texto = "";
    texto = mes + "\t" + deuda + "\t" + capital + "\t"
            + "\t" + interes + "\t" + cuota;
    return texto;
  }

  
}
