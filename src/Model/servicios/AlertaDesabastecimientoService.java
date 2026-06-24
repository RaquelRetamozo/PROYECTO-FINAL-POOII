package Model.servicios;

import Model.entidades.Stock;
import Model.repositorios.IStockRepository;
import java.util.ArrayList;
import java.util.List;

public class AlertaDesabastecimientoService {

    //Atributos
    private IStockRepository stockRepository;

    //Constructor
    public AlertaDesabastecimientoService(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    //Métodos
    public List<Stock> listarStockCritico() {
        List<Stock> criticos = new ArrayList<>();
        for (Stock s : stockRepository.listarTodos()) {
            if (s.hayDesabastecimiento()) {
                criticos.add(s);
            }
        }
        return criticos;
    }

    public void verificarYAlertarDesabastecimiento() {
        List<Stock> criticos = listarStockCritico();
        for (Stock s : criticos) {
            System.out.println("⚠ ALERTA STOCK - Producto: " +
                    s.getLote().getProducto().getNombre() +
                    " | Disponible: " + s.getCantidadDisponible() +
                    " | Minimo: " + s.getCantidadMinima());
        }
    }
}
