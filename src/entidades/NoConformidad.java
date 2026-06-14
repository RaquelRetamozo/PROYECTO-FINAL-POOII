package entidades;
import java.time.LocalDate;

public class NoConformidad {

    //Atributos
    private String idNoConformidad;
    private String descripcion;
    private String area;
    private String nivel;           // LEVE, MODERADO, CRITICO
    private String estado;          // ABIERTA, EN_PROCESO, CERRADA
    private LocalDate fechaDeteccion;
    private LocalDate fechaCierre;
    private String responsable;
    private Lote lote;

    //Constructor
    public NoConformidad(String idNoConformidad, String descripcion, String area,
                         String nivel, String responsable, Lote lote) {
        this.idNoConformidad = idNoConformidad;
        this.descripcion = descripcion;
        this.area = area;
        this.nivel = nivel;
        this.responsable = responsable;
        this.lote = lote;
        this.estado = "ABIERTA";
        this.fechaDeteccion = LocalDate.now();
        this.fechaCierre = null;
    }

    //Métodos
    public void cerrar() {
        this.estado = "CERRADA";
        this.fechaCierre = LocalDate.now();
    }

    public boolean estaCerrada() {
        return estado.equals("CERRADA");
    }

    public boolean esCritica() {
        return nivel.equals("CRITICO");
    }

    //Getters
    public String getIdNoConformidad() { return idNoConformidad; }
    public String getDescripcion() { return descripcion; }
    public String getArea() { return area; }
    public String getNivel() { return nivel; }
    public String getEstado() { return estado; }
    public LocalDate getFechaDeteccion() { return fechaDeteccion; }
    public LocalDate getFechaCierre() { return fechaCierre; }
    public String getResponsable() { return responsable; }
    public Lote getLote() { return lote; }

    //Setters
    public void setIdNoConformidad(String idNoConformidad) { this.idNoConformidad = idNoConformidad; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setArea(String area) { this.area = area; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setFechaCierre(LocalDate fechaCierre) { this.fechaCierre = fechaCierre; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public void setLote(Lote lote) { this.lote = lote; }

    //ToString
    @Override
    public String toString() {
        return "NoConformidad: " + idNoConformidad +
                " | Nivel: " + nivel +
                " | Area: " + area +
                " | Estado: " + estado +
                " | Detectada: " + fechaDeteccion +
                " | Responsable: " + responsable +
                " | Lote: " + lote.getNumeroLote();
    }
}