package Model.entidades;

import java.util.List;

public class Almacen {

    //Atributos
    private String idAlmacen;
    private String nombre;
    private String direccion;
    private double capacidadTotal;
    private List<Ubicacion> ubicaciones;
    private List<ZonaAlmacen> zonas;

    //Constructor
    public Almacen(String idAlmacen, String nombre, String direccion, double capacidadTotal, List<Ubicacion> ubicaciones, List<ZonaAlmacen> zonas) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadTotal = capacidadTotal;
        this.ubicaciones = ubicaciones;
        this.zonas = zonas;
    }

    //Metodo
    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicaciones.add(ubicacion);
    }

    public void agregarZona(ZonaAlmacen zona) {
        zonas.add(zona);
    }

    public int getTotalUbicacionesLibres() {
        int count = 0;
        for (Ubicacion u : ubicaciones) {
            if (!u.isOcupado()) count++;
        }
        return count;
    }

    public int getTotalUbicacionesOcupadas() {
        int count = 0;
        for (Ubicacion u : ubicaciones) {
            if (u.isOcupado()) count++;
        }
        return count;
    }

    // Getters
    public String getIdAlmacen() {
        return idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getCapacidadTotal() {
        return capacidadTotal;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public List<ZonaAlmacen> getZonas() {
        return zonas;
    }

    //Setters
    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCapacidadTotal(double capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

}
