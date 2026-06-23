package Model.entidades;

public class Transportista {

    //Atributos
    private String idTransportista;
    private String nombre;
    private String dni;
    private String licencia;
    private String telefono;
    private String placa;       // placa del vehículo
    private String tipoVehiculo;

    //Constructor
    public Transportista(String idTransportista, String nombre, String dni, String licencia, String telefono, String placa, String tipoVehiculo) {
        this.idTransportista = idTransportista;
        this.nombre = nombre;
        this.dni = dni;
        this.licencia = licencia;
        this.telefono = telefono;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    //Getters
    public String getIdTransportista() {
        return idTransportista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getLicencia() {
        return licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    //Setters
    public void setIdTransportista(String idTransportista) {
        this.idTransportista = idTransportista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
