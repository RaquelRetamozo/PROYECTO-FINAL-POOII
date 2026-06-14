package entidades;

import java.time.LocalDateTime;

public class LecturaSensor {

    //Atributos
    private String idLectura;
    private String idSensor;
    private ZonaAlmacen zona;
    private double valor;
    private LocalDateTime fechaHora;
    private boolean dentroRango;

    //Constructor
    public LecturaSensor(String idLectura, String idSensor,
                         ZonaAlmacen zona, double valor) {
        this.idLectura = idLectura;
        this.idSensor = idSensor;
        this.zona = zona;
        this.valor = valor;
        this.fechaHora = LocalDateTime.now();
        this.dentroRango = true;
    }

    //Metodo
    public String getTipoLectura() {
        return "SENSOR";
    }

    // Getters
    public String getIdLectura() { return idLectura; }
    public String getIdSensor() { return idSensor; }
    public ZonaAlmacen getZona() { return zona; }
    public double getValor() { return valor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public boolean isDentroRango() { return dentroRango; }

    // Setters
    public void setIdLectura(String idLectura) { this.idLectura = idLectura; }
    public void setIdSensor(String idSensor) { this.idSensor = idSensor; }
    public void setZona(ZonaAlmacen zona) { this.zona = zona; }
    public void setValor(double valor) { this.valor = valor; }
    public void setDentroRango(boolean dentroRango) { this.dentroRango = dentroRango; }

}