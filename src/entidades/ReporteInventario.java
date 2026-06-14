package entidades;
import java.util.ArrayList;
import java.util.List;

public class ReporteInventario extends Reporte {

    //Atributos
    private List<Stock> stockList;
    private int totalProductos;
    private int totalLotesVencidos;
    private int totalBajoStock;

    //Constructor
    public ReporteInventario(String idReporte, String titulo,
                             String descripcion, String generadoPor) {
        super(idReporte, titulo, descripcion, generadoPor);
        this.stockList = new ArrayList<>();
        this.totalProductos = 0;
        this.totalLotesVencidos = 0;
        this.totalBajoStock = 0;
    }

    //Métodos
    @Override
    public String getTipoReporte() {
        return "INVENTARIO";
    }

    public void agregarStock(Stock stock) {
        stockList.add(stock);
        totalProductos++;
        if (stock.getLote().estaVencido()) totalLotesVencidos++;
        if (stock.hayDesabastecimiento()) totalBajoStock++;
    }

    //Getters
    public List<Stock> getStockList() { return stockList; }
    public int getTotalProductos() { return totalProductos; }
    public int getTotalLotesVencidos() { return totalLotesVencidos; }
    public int getTotalBajoStock() { return totalBajoStock; }

    //Setters
    public void setStockList(List<Stock> stockList) { this.stockList = stockList; }
    public void setTotalProductos(int totalProductos) { this.totalProductos = totalProductos; }
    public void setTotalLotesVencidos(int totalLotesVencidos) { this.totalLotesVencidos = totalLotesVencidos; }
    public void setTotalBajoStock(int totalBajoStock) { this.totalBajoStock = totalBajoStock; }
}