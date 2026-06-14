package entidades;
import java.util.ArrayList;
import java.util.List;

public class ReporteTrazabilidad extends Reporte {

    //Atributos
    private List<Despacho> despachos;
    private List<MovimientoInventario> movimientos;
    private int totalDespachos;
    private int totalMovimientos;

    //Constructor
    public ReporteTrazabilidad(String idReporte, String titulo,
                               String descripcion, String generadoPor) {
        super(idReporte, titulo, descripcion, generadoPor);
        this.despachos = new ArrayList<>();
        this.movimientos = new ArrayList<>();
        this.totalDespachos = 0;
        this.totalMovimientos = 0;
    }

    //Métodos
    @Override
    public String getTipoReporte() {
        return "TRAZABILIDAD";
    }

    public void agregarDespacho(Despacho despacho) {
        despachos.add(despacho);
        totalDespachos++;
    }

    public void agregarMovimiento(MovimientoInventario movimiento) {
        movimientos.add(movimiento);
        totalMovimientos++;
    }

    //Getters
    public List<Despacho> getDespachos() { return despachos; }
    public List<MovimientoInventario> getMovimientos() { return movimientos; }
    public int getTotalDespachos() { return totalDespachos; }
    public int getTotalMovimientos() { return totalMovimientos; }

    //Setters
    public void setDespachos(List<Despacho> despachos) { this.despachos = despachos; }
    public void setMovimientos(List<MovimientoInventario> movimientos) { this.movimientos = movimientos; }
    public void setTotalDespachos(int totalDespachos) { this.totalDespachos = totalDespachos; }
    public void setTotalMovimientos(int totalMovimientos) { this.totalMovimientos = totalMovimientos; }
}