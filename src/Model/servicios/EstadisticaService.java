package Model.servicios;

import Model.entidades.Despacho;
import Model.entidades.Stock;
import Model.repositorios.IDespachoRepository;
import Model.repositorios.IStockRepository;
import java.util.List;

public class EstadisticaService {

    //Atributos
    private IStockRepository stockRepository;
    private IDespachoRepository despachoRepository;

    //Constructor
    public EstadisticaService(IStockRepository stockRepository,
                              IDespachoRepository despachoRepository) {
        this.stockRepository = stockRepository;
        this.despachoRepository = despachoRepository;
    }

    //Métodos
    public int getTotalProductosEnStock() {
        return stockRepository.listarTodos().size();
    }

    public double getMontoTotalDespachos() {
        double total = 0;
        for (Despacho d : despachoRepository.listarTodos()) {
            total += d.getTotalDespacho();
        }
        return total;
    }

    public int getTotalDespachosEntregados() {
        int count = 0;
        for (Despacho d : despachoRepository.listarTodos()) {
            if (d.getEstado().equals("ENTREGADO")) count++;
        }
        return count;
    }

    public int getTotalStockCritico() {
        int count = 0;
        for (Stock s : stockRepository.listarTodos()) {
            if (s.hayDesabastecimiento()) count++;
        }
        return count;
    }
}