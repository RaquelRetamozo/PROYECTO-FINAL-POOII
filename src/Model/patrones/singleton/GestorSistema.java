package Model.patrones.singleton;

public class GestorSistema {

    //Atributos
    private static GestorSistema instancia;
    private String nombreSistema;
    private String version;

    //Constructor
    private GestorSistema() {
        this.nombreSistema = "CRAMER PERU - Sistema de Gestión";
        this.version = "1.0.0";
    }

    //Métodos
    public static GestorSistema getInstancia() {
        if (instancia == null) {
            instancia = new GestorSistema();
        }
        return instancia;
    }

    //Getters
    public String getNombreSistema() { return nombreSistema; }
    public String getVersion() { return version; }

    //Setters
    public void setNombreSistema(String nombreSistema) { this.nombreSistema = nombreSistema; }
    public void setVersion(String version) { this.version = version; }
}