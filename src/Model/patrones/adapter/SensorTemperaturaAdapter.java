package Model.patrones.adapter;

import Model.entidades.LecturaTemperatura;
import Model.entidades.ZonaAlmacen;

public class SensorTemperaturaAdapter {

    //Atributos
    private String idSensor;
    private ZonaAlmacen zona;

    //Constructor
    public SensorTemperaturaAdapter(String idSensor, ZonaAlmacen zona) {
        this.idSensor = idSensor;
        this.zona = zona;
    }

    //Métodos
    public LecturaTemperatura obtenerLectura(double valorExterno) {
        return new LecturaTemperatura(
                "LT-" + System.currentTimeMillis(),
                idSensor,
                zona,
                valorExterno,
                zona.getTemperaturaMin(),
                zona.getTemperaturaMax()
        );
    }

    //Getters
    public String getIdSensor() { return idSensor; }
    public ZonaAlmacen getZona() { return zona; }

    //Setters
    public void setIdSensor(String idSensor) { this.idSensor = idSensor; }
    public void setZona(ZonaAlmacen zona) { this.zona = zona; }
}