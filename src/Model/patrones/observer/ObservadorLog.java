package Model.patrones.observer;

import Model.patrones.singleton.LoggerSistema;

public class ObservadorLog implements IObservador {

    //Atributos
    private String nombre;
    private LoggerSistema logger;

    //Constructor
    public ObservadorLog(String nombre) {
        this.nombre = nombre;
        this.logger = LoggerSistema.getInstancia();
    }

    //Métodos
    @Override
    public void actualizar(String evento, Object dato) {
        logger.logInfo("[" + nombre + "] Evento: " + evento + " | Valor: " + dato);
    }

    //Getters
    public String getNombre() { return nombre; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
}