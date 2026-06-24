package Model.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class SujetoSensor implements ISujeto {

    //Atributos
    private List<IObservador> observadores;
    private double ultimaLectura;
    private String idSensor;

    //Constructor
    public SujetoSensor(String idSensor) {
        this.idSensor = idSensor;
        this.observadores = new ArrayList<>();
        this.ultimaLectura = 0;
    }

    //Métodos
    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String evento, Object dato) {
        for (IObservador o : observadores) {
            o.actualizar(evento, dato);
        }
    }

    public void registrarLectura(double valor) {
        this.ultimaLectura = valor;
        notificarObservadores("NUEVA_LECTURA", valor);
    }

    //Getters
    public String getIdSensor() { return idSensor; }
    public double getUltimaLectura() { return ultimaLectura; }

    //Setters
    public void setIdSensor(String idSensor) { this.idSensor = idSensor; }
}