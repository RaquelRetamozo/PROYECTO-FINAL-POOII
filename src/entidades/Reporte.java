package entidades;
import java.time.LocalDate;

public abstract class Reporte {

    //Atributos
    private String idReporte;
    private String titulo;
    private String descripcion;
    private LocalDate fechaGeneracion;
    private String generadoPor;

    //Constructor
    public Reporte(String idReporte, String titulo,
                   String descripcion, String generadoPor) {
        this.idReporte = idReporte;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.generadoPor = generadoPor;
        this.fechaGeneracion = LocalDate.now();
    }

    //Métodos
    public abstract String getTipoReporte();

    //Getters
    public String getIdReporte() { return idReporte; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public String getGeneradoPor() { return generadoPor; }

    //Setters
    public void setIdReporte(String idReporte) { this.idReporte = idReporte; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setGeneradoPor(String generadoPor) { this.generadoPor = generadoPor; }
}