package Model.patrones.observer;

public class ObservadorNotificacion implements IObservador {

    //Atributos
    private String nombre;
    private String ultimaNotificacion;

    //Constructor
    public ObservadorNotificacion(String nombre) {
        this.nombre = nombre;
        this.ultimaNotificacion = "";
    }

    //Métodos
    @Override
    public void actualizar(String evento, Object dato) {
        ultimaNotificacion = "NOTIFICACION [" + nombre + "] - " +
                evento + ": " + dato;
        System.out.println(ultimaNotificacion);
    }

    //Getters
    public String getNombre() { return nombre; }
    public String getUltimaNotificacion() { return ultimaNotificacion; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
}