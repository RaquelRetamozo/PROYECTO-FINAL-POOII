package Model.patrones.observer;

public class ObservadorAlerta implements IObservador {

    //Atributos
    private String nombre;

    //Constructor
    public ObservadorAlerta(String nombre) {
        this.nombre = nombre;
    }

    //Métodos
    @Override
    public void actualizar(String evento, Object dato) {
        System.out.println("⚠ ALERTA [" + nombre + "] - Evento: " + evento +
                " | Valor: " + dato);
    }

    //Getters
    public String getNombre() { return nombre; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
}