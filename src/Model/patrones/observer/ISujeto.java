package Model.patrones.observer;

public interface ISujeto {
    void agregarObservador(IObservador observador);
    void eliminarObservador(IObservador observador);
    void notificarObservadores(String evento, Object dato);
}