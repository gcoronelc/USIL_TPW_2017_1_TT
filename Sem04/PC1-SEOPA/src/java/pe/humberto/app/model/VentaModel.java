package pe.humberto.app.model;

public class VentaModel {

  // Input
  private String producto;
  private int tamLote;
  private double precLote;
  private int porcGastos;
  private int porcGanancia;

  // Output
  private int uniComerc;
  private double costoTotal;
  private double costoUnidad;
  private double precVentaUni;

  public VentaModel() {
  }

  public VentaModel(String producto, int tamLote, double precLote, int porcGastos, int porcGanancia) {
    this.producto = producto;
    this.tamLote = tamLote;
    this.precLote = precLote;
    this.porcGastos = porcGastos;
    this.porcGanancia = porcGanancia;
  }

  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }

  public int getTamLote() {
    return tamLote;
  }

  public void setTamLote(int tamLote) {
    this.tamLote = tamLote;
  }

  public double getPrecLote() {
    return precLote;
  }

  public void setPrecLote(double precLote) {
    this.precLote = precLote;
  }

  public int getPorcGastos() {
    return porcGastos;
  }

  public void setPorcGastos(int porcGastos) {
    this.porcGastos = porcGastos;
  }

  public int getPorcGanancia() {
    return porcGanancia;
  }

  public void setPorcGanancia(int porcGanancia) {
    this.porcGanancia = porcGanancia;
  }

  public int getUniComerc() {
    return uniComerc;
  }

  public void setUniComerc(int uniComerc) {
    this.uniComerc = uniComerc;
  }

  public double getCostoTotal() {
    return costoTotal;
  }

  public void setCostoTotal(double costoTotal) {
    this.costoTotal = costoTotal;
  }

  public double getCostoUnidad() {
    return costoUnidad;
  }

  public void setCostoUnidad(double costoUnidad) {
    this.costoUnidad = costoUnidad;
  }

  public double getPrecVentaUni() {
    return precVentaUni;
  }

  public void setPrecVentaUni(double precVentaUni) {
    this.precVentaUni = precVentaUni;
  }

}
