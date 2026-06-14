package entidades;
import java.time.LocalDate;

public class Stock {
    //Atributos
    private String idStock;
    private Lote lote;
    private int cantidadDisponible;
    private int cantidadMinima;            // para alerta de desabastecimiento
    private LocalDate ultimaActualizacion;

    //Constructor
    public Stock(String idStock, Lote lote, int cantidadDisponible, int cantidadMinima, LocalDate ultimaActualizacion) {
        this.idStock = idStock;
        this.lote = lote;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadMinima = cantidadMinima;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    //Metodo
    public boolean hayDesabastecimiento() {
        return cantidadDisponible <= cantidadMinima;
    }

    public void reducir(int cantidad) {
        this.cantidadDisponible -= cantidad;
        this.ultimaActualizacion = LocalDate.now();
    }

    public void aumentar(int cantidad) {
        this.cantidadDisponible += cantidad;
        this.ultimaActualizacion = LocalDate.now();
    }

    //Getters
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public String getIdStock() {
        return idStock;
    }

    public Lote getLote() {
        return lote;
    }

    public LocalDate getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    //Setters
    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

}
