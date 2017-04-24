package pe.henry.app.model;
public class VentaModel {
    
    //Input
    private String nombre;
    private double cantidad;
    private double costo;
    private double gastoporcentaje;
    private double ganancia;
    
    //output
    private double tocantidad;
    private double costotal;
    private double costunid;
    private double preventa;

    public VentaModel(String nombre, double cantidad, double costo, double gastoporcentaje, double ganancia) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
        this.gastoporcentaje = gastoporcentaje;
        this.ganancia = ganancia;
    }
    
    public VentaModel(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getGastoporcentaje() {
        return gastoporcentaje;
    }

    public void setGastoporcentaje(double gastoporcentaje) {
        this.gastoporcentaje = gastoporcentaje;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getTocantidad() {
        return tocantidad;
    }

    public void setTocantidad(double tocantidad) {
        this.tocantidad = tocantidad;
    }

    public double getCostotal() {
        return costotal;
    }

    public void setCostotal(double costotal) {
        this.costotal = costotal;
    }

    public double getCostunid() {
        return costunid;
    }

    public void setCostunid(double costunid) {
        this.costunid = costunid;
    }

    public double getPreventa() {
        return preventa;
    }

    public void setPreventa(double preventa) {
        this.preventa = preventa;
    }

    
    
    
    
}
