package entidades;

public class Ubicacion {

    // Atributos
    private String idUbicacion;
    private String pasillo;
    private String estante;
    private String nivel;
    private boolean ocupado;

    // Constructor
    public Ubicacion(String idUbicacion, String pasillo, String estante, String nivel, boolean ocupado) {
        this.idUbicacion = idUbicacion;
        this.pasillo = pasillo;
        this.estante = estante;
        this.nivel = nivel;
        this.ocupado = ocupado;
    }

    // Metodo
    public String getDireccionCompleta() {
        return "Pasillo " + pasillo + " - Estante " + estante + " - Nivel " + nivel;
    }

    // Getters
    public String getIdUbicacion() {
        return idUbicacion;
    }

    public String getPasillo() {
        return pasillo;
    }

    public String getEstante() {
        return estante;
    }

    public String getNivel() {
        return nivel;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    // Setters
    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
