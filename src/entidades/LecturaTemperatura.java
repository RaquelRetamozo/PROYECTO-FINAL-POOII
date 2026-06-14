package entidades;

import java.time.LocalDateTime;

public class LecturaTemperatura extends LecturaSensor {

    //Atributos
    private double temperaturaRegistrada;
    private double temperaturaMin;
    private double temperaturaMax;

    //Constructor
    public LecturaTemperatura(String idLectura, String idSensor, ZonaAlmacen zona,
                              double valor, double temperaturaMin, double temperaturaMax) {
        super(idLectura, idSensor, zona, valor);
        this.temperaturaRegistrada = valor;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.setDentroRango(temperaturaRegistrada >= temperaturaMin &&
                temperaturaRegistrada <= temperaturaMax);
    }

    //Métodos
    public boolean estaFueraDeRango() {
        return !isDentroRango();
    }

    @Override
    public String getTipoLectura() {
        return "TEMPERATURA";
    }

    //Getters
    public double getTemperaturaRegistrada() { return temperaturaRegistrada; }
    public double getTemperaturaMin() { return temperaturaMin; }
    public double getTemperaturaMax() { return temperaturaMax; }

    //Setters
    public void setTemperaturaRegistrada(double temperaturaRegistrada) { this.temperaturaRegistrada = temperaturaRegistrada; }
    public void setTemperaturaMin(double temperaturaMin) { this.temperaturaMin = temperaturaMin; }
    public void setTemperaturaMax(double temperaturaMax) { this.temperaturaMax = temperaturaMax; }

}