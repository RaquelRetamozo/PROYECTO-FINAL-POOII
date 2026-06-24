package Model.patrones.singleton;

public class ConfiguracionSistema {

    //Atributos
    private static ConfiguracionSistema instancia;
    private int diasAlertaVencimiento;
    private int stockMinimoDefecto;
    private String moneda;

    //Constructor
    private ConfiguracionSistema() {
        this.diasAlertaVencimiento = 30;
        this.stockMinimoDefecto = 10;
        this.moneda = "S/.";
    }

    //Métodos
    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    //Getters
    public int getDiasAlertaVencimiento() { return diasAlertaVencimiento; }
    public int getStockMinimoDefecto() { return stockMinimoDefecto; }
    public String getMoneda() { return moneda; }

    //Setters
    public void setDiasAlertaVencimiento(int dias) { this.diasAlertaVencimiento = dias; }
    public void setStockMinimoDefecto(int stock) { this.stockMinimoDefecto = stock; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
}