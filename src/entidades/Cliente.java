package entidades;

public class Cliente {

    //Atributo
    private String idCliente;
    private String razonSocial;
    private String ruc;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;    // nombre de la persona de contacto

    //Constructor
    public Cliente(String idCliente, String razonSocial, String ruc, String direccion, String telefono, String email, String contacto) {
        this.idCliente = idCliente;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contacto = contacto;
    }

    //Getters
    public String getIdCliente() {
        return idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContacto() {
        return contacto;
    }

    //Setters
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

}
