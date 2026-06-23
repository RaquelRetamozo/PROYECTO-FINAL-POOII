package Model.entidades;
import java.util.ArrayList;
import java.util.List;

public class ReporteCalidad extends Reporte {

    //Atributos
    private List<NoConformidad> noConformidades;
    private List<Reclamo> reclamos;
    private int totalNoConformidades;
    private int totalReclamos;
    private int totalCriticos;

    //Constructor
    public ReporteCalidad(String idReporte, String titulo,
                          String descripcion, String generadoPor) {
        super(idReporte, titulo, descripcion, generadoPor);
        this.noConformidades = new ArrayList<>();
        this.reclamos = new ArrayList<>();
        this.totalNoConformidades = 0;
        this.totalReclamos = 0;
        this.totalCriticos = 0;
    }

    //Métodos
    @Override
    public String getTipoReporte() {
        return "CALIDAD";
    }

    public void agregarNoConformidad(NoConformidad noConformidad) {
        noConformidades.add(noConformidad);
        totalNoConformidades++;
        if (noConformidad.esCritica()) totalCriticos++;
    }

    public void agregarReclamo(Reclamo reclamo) {
        reclamos.add(reclamo);
        totalReclamos++;
    }

    //Getters
    public List<NoConformidad> getNoConformidades() { return noConformidades; }
    public List<Reclamo> getReclamos() { return reclamos; }
    public int getTotalNoConformidades() { return totalNoConformidades; }
    public int getTotalReclamos() { return totalReclamos; }
    public int getTotalCriticos() { return totalCriticos; }

    //Setters
    public void setNoConformidades(List<NoConformidad> noConformidades) { this.noConformidades = noConformidades; }
    public void setReclamos(List<Reclamo> reclamos) { this.reclamos = reclamos; }
    public void setTotalNoConformidades(int totalNoConformidades) { this.totalNoConformidades = totalNoConformidades; }
    public void setTotalReclamos(int totalReclamos) { this.totalReclamos = totalReclamos; }
    public void setTotalCriticos(int totalCriticos) { this.totalCriticos = totalCriticos; }
}
