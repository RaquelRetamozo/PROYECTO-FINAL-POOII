package entidades;

public class UmbralAmbiental {

    //Atributos
    private String idUmbral;
    private String nombre;
    private double temperaturaMin;
    private double temperaturaMax;
    private double humedadMin;
    private double humedadMax;
    private String tipoProducto;    // LIQUIDO o POLVO

    //Constructor
    public UmbralAmbiental(String idUmbral, String nombre, double temperaturaMin,
                           double temperaturaMax, double humedadMin,
                           double humedadMax, String tipoProducto) {
        this.idUmbral = idUmbral;
        this.nombre = nombre;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.humedadMin = humedadMin;
        this.humedadMax = humedadMax;
        this.tipoProducto = tipoProducto;
    }

    //Métodos
    public boolean temperaturaPermitida(double temperatura) {
        return temperatura >= temperaturaMin && temperatura <= temperaturaMax;
    }

    public boolean humedadPermitida(double humedad) {
        return humedad >= humedadMin && humedad <= humedadMax;
    }

    public boolean condicionesPermitidas(double temperatura, double humedad) {
        return temperaturaPermitida(temperatura) && humedadPermitida(humedad);
    }

    //Getters
    public String getIdUmbral() { return idUmbral; }
    public String getNombre() { return nombre; }
    public double getTemperaturaMin() { return temperaturaMin; }
    public double getTemperaturaMax() { return temperaturaMax; }
    public double getHumedadMin() { return humedadMin; }
    public double getHumedadMax() { return humedadMax; }
    public String getTipoProducto() { return tipoProducto; }

    //Setters
    public void setIdUmbral(String idUmbral) { this.idUmbral = idUmbral; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTemperaturaMin(double temperaturaMin) { this.temperaturaMin = temperaturaMin; }
    public void setTemperaturaMax(double temperaturaMax) { this.temperaturaMax = temperaturaMax; }
    public void setHumedadMin(double humedadMin) { this.humedadMin = humedadMin; }
    public void setHumedadMax(double humedadMax) { this.humedadMax = humedadMax; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }

}
