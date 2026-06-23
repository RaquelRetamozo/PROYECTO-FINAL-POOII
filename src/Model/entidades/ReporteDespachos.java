package Model.entidades;
import java.util.ArrayList;
import java.util.List;

public class ReporteDespachos extends Reporte {

    //Atributos
    private List<Despacho> despachos;
    private int totalDespachos;
    private int totalEntregados;
    private int totalPendientes;
    private int totalCancelados;
    private double montoTotal;

    //Constructor
    public ReporteDespachos(String idReporte, String titulo,
                            String descripcion, String generadoPor) {
        super(idReporte, titulo, descripcion, generadoPor);
        this.despachos = new ArrayList<>();
        this.totalDespachos = 0;
        this.totalEntregados = 0;
        this.totalPendientes = 0;
        this.totalCancelados = 0;
        this.montoTotal = 0.0;
    }

    //Métodos
    @Override
    public String getTipoReporte() {
        return "DESPACHOS";
    }

    public void agregarDespacho(Despacho despacho) {
        despachos.add(despacho);
        totalDespachos++;
        montoTotal += despacho.getTotalDespacho();
        switch (despacho.getEstado()) {
            case "ENTREGADO":  totalEntregados++;  break;
            case "PENDIENTE":  totalPendientes++;  break;
            case "CANCELADO":  totalCancelados++;  break;
        }
    }

    //Getters
    public List<Despacho> getDespachos() { return despachos; }
    public int getTotalDespachos() { return totalDespachos; }
    public int getTotalEntregados() { return totalEntregados; }
    public int getTotalPendientes() { return totalPendientes; }
    public int getTotalCancelados() { return totalCancelados; }
    public double getMontoTotal() { return montoTotal; }

    //Setters
    public void setDespachos(List<Despacho> despachos) { this.despachos = despachos; }
    public void setTotalDespachos(int totalDespachos) { this.totalDespachos = totalDespachos; }
    public void setTotalEntregados(int totalEntregados) { this.totalEntregados = totalEntregados; }
    public void setTotalPendientes(int totalPendientes) { this.totalPendientes = totalPendientes; }
    public void setTotalCancelados(int totalCancelados) { this.totalCancelados = totalCancelados; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}