package Model.entidades;

public class Usuario {

    //Atributos
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol;         // ADMINISTRADOR, OPERARIO, GERENTE, AUDITOR

    //Constructor
    public Usuario(String idUsuario, String nombre, String apellido,
                   String email, String password, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    //Métodos
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    //Getters
    public String getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }

    //Setters
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRol(String rol) { this.rol = rol; }
}