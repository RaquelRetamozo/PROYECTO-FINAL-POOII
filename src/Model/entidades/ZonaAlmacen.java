package Model.entidades;

import java.util.List;

public class ZonaAlmacen {

    //Atributos
    private String idZona;
    private String nombre;
    private double temperaturaMin;
    private double temperaturaMax;
    private double humedadMin;
    private double humedadMax;
    private String tipoProductoPermitido;   // LIQUIDO o POLVO
    private List<Ubicacion> ubicaciones;

    //Constructor
    public ZonaAlmacen(String idZona, String nombre, double temperaturaMin, double temperaturaMax, double humedadMin, double humedadMax, String tipoProductoPermitido, List<Ubicacion> ubicaciones) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.humedadMin = humedadMin;
        this.humedadMax = humedadMax;
        this.tipoProductoPermitido = tipoProductoPermitido;
        this.ubicaciones = ubicaciones;
    }

    //Metodo
    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicaciones.add(ubicacion);
    }

    public boolean temperaturaEnRango(double temperatura) {
        return temperatura >= temperaturaMin && temperatura <= temperaturaMax;
    }

    public boolean humedadEnRango(double humedad) {
        return humedad >= humedadMin && humedad <= humedadMax;
    }

    public boolean condicionesAptas(double temperatura, double humedad) {
        return temperaturaEnRango(temperatura) && humedadEnRango(humedad);
    }

    //Getters

    public String getIdZona() {
        return idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperaturaMin() {
        return temperaturaMin;
    }

    public double getTemperaturaMax() {
        return temperaturaMax;
    }

    public double getHumedadMin() {
        return humedadMin;
    }

    public double getHumedadMax() {
        return humedadMax;
    }

    public String getTipoProductoPermitido() {
        return tipoProductoPermitido;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    //Setters

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemperaturaMin(double temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public void setTemperaturaMax(double temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public void setHumedadMin(double humedadMin) {
        this.humedadMin = humedadMin;
    }

    public void setHumedadMax(double humedadMax) {
        this.humedadMax = humedadMax;
    }

    public void setTipoProductoPermitido(String tipoProductoPermitido) {
        this.tipoProductoPermitido = tipoProductoPermitido;
    }

}
