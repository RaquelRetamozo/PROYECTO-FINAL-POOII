package entidades;

import java.time.LocalDate;

public class ProductoPolvo extends Producto {

    //Atributos
    private double humedadMaxima;  // en %
    private double granulometria;  //en nm

    //Constructor
    public ProductoPolvo(String idProducto, String nombre, LocalDate fechaFabricacion, LocalDate fechaVencimiento, double cantidad, String dosis, double granulometria, double humedadMaxima) {
        super(idProducto, nombre, fechaFabricacion, fechaVencimiento, cantidad, dosis);
        this.granulometria = granulometria;
        this.humedadMaxima = humedadMaxima;
    }

    //Metodo
    @Override
    public String getTipo() {
        return "POLVO";
    }

    //Getters
    public double getGranulometria() {
        return granulometria;
    }

    public double getHumedadMaxima() {
        return humedadMaxima;
    }

    //Setters
    public void setGranulometria(double granulometria) {
        this.granulometria = granulometria;
    }

    public void setHumedadMaxima(double humedadMaxima) {
        this.humedadMaxima = humedadMaxima;
    }

}
