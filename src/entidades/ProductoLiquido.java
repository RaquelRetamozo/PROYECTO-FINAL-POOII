package entidades;

import java.time.LocalDate;

public class ProductoLiquido extends Producto {

    //Atributos
    private double viscosidad;        // en cP
    private double temperaturaMaxima; // en °C

    //Constructor
    public ProductoLiquido(String idProducto, String nombre, LocalDate fechaFabricacion, LocalDate fechaVencimiento, double cantidad, String dosis, double temperaturaMaxima, double viscosidad) {
        super(idProducto, nombre, fechaFabricacion, fechaVencimiento, cantidad, dosis);
        this.temperaturaMaxima = temperaturaMaxima;
        this.viscosidad = viscosidad;
    }

    //Metodo
    @Override
    public String getTipo() {
        return "LIQUIDO";
    }

    //Getters
    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public double getViscosidad() {
        return viscosidad;
    }

    //Setters
    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public void setViscosidad(double viscosidad) {
        this.viscosidad = viscosidad;
    }

}
