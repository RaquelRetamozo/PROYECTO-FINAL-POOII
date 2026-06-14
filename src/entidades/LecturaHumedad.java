package entidades;

public class LecturaHumedad extends LecturaSensor {

    //Atributos
    private double humedadRegistrada;
    private double humedadMin;
    private double humedadMax;

    //Constructor
    public LecturaHumedad(String idLectura, String idSensor, ZonaAlmacen zona,
                          double valor, double humedadMin, double humedadMax) {
        super(idLectura, idSensor, zona, valor);
        this.humedadRegistrada = valor;
        this.humedadMin = humedadMin;
        this.humedadMax = humedadMax;
        this.setDentroRango(humedadRegistrada >= humedadMin &&
                humedadRegistrada <= humedadMax);
    }

    //Métodos
    public boolean estaFueraDeRango() {
        return !isDentroRango();
    }

    @Override
    public String getTipoLectura() {
        return "HUMEDAD";
    }

    //Getters
    public double getHumedadRegistrada() { return humedadRegistrada; }
    public double getHumedadMin() { return humedadMin; }
    public double getHumedadMax() { return humedadMax; }

    //Setters
    public void setHumedadRegistrada(double humedadRegistrada) { this.humedadRegistrada = humedadRegistrada; }
    public void setHumedadMin(double humedadMin) { this.humedadMin = humedadMin; }
    public void setHumedadMax(double humedadMax) { this.humedadMax = humedadMax; }

}