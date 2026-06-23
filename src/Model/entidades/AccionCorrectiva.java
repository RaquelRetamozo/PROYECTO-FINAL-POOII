package Model.entidades;
import java.time.LocalDate;

public class AccionCorrectiva {

    //Atributos
    private String idAccion;
    private NoConformidad noConformidad;
    private String descripcion;
    private String responsable;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private LocalDate fechaCierre;
    private String estado;          // PENDIENTE, EN_PROCESO, CERRADA

    //Constructor
    public AccionCorrectiva(String idAccion, NoConformidad noConformidad,
                            String descripcion, String responsable,
                            LocalDate fechaLimite) {
        this.idAccion = idAccion;
        this.noConformidad = noConformidad;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fechaInicio = LocalDate.now();
        this.fechaLimite = fechaLimite;
        this.fechaCierre = null;
        this.estado = "PENDIENTE";
    }

    //Métodos
    public void cerrar() {
        this.estado = "CERRADA";
        this.fechaCierre = LocalDate.now();
    }

    public boolean estaVencida() {
        return LocalDate.now().isAfter(fechaLimite) && !estado.equals("CERRADA");
    }

    //Getters
    public String getIdAccion() { return idAccion; }
    public NoConformidad getNoConformidad() { return noConformidad; }
    public String getDescripcion() { return descripcion; }
    public String getResponsable() { return responsable; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public LocalDate getFechaCierre() { return fechaCierre; }
    public String getEstado() { return estado; }

    //Setters
    public void setIdAccion(String idAccion) { this.idAccion = idAccion; }
    public void setNoConformidad(NoConformidad noConformidad) { this.noConformidad = noConformidad; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    public void setEstado(String estado) { this.estado = estado; }
}