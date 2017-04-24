package pe.egcc.app.model;

public class PromModel {

  // Input
  private double promPract;
  private double exaParcial;
  private double exaFinal;
  // Output
  private double promFinal;
  private String estado;

  public PromModel() {
  }

  public PromModel(double promPract, double exaParcial, double exaFinal) {
    this.promPract = promPract;
    this.exaParcial = exaParcial;
    this.exaFinal = exaFinal;
  }

  public double getPromPract() {
    return promPract;
  }

  public void setPromPract(double promPract) {
    this.promPract = promPract;
  }

  public double getExaParcial() {
    return exaParcial;
  }

  public void setExaParcial(double exaParcial) {
    this.exaParcial = exaParcial;
  }

  public double getExaFinal() {
    return exaFinal;
  }

  public void setExaFinal(double exaFinal) {
    this.exaFinal = exaFinal;
  }

  public double getPromFinal() {
    return promFinal;
  }

  public void setPromFinal(double promFinal) {
    this.promFinal = promFinal;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

}
