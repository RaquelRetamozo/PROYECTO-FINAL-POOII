package Model.servicios;

import Model.entidades.Lote;
import Model.entidades.Stock;
import Model.excepciones.StockInsuficienteException;
import Model.repositorios.IStockRepository;
import java.util.List;

public class StockService {

    //Atributos
    private IStockRepository stockRepository;

    //Constructor
    public StockService(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    //Métodos
    public void registrarStock(Stock stock) {
        stockRepository.agregar(stock);
    }

    public Stock buscarStock(String idStock) {
        Stock stock = stockRepository.buscarPorId(idStock);
        if (stock == null) {
            throw new StockInsuficienteException(idStock);
        }
        return stock;
    }

    public List<Stock> listarStocks() {
        return stockRepository.listarTodos();
    }

    public void reducirStock(String idStock, int cantidad) {
        Stock stock = buscarStock(idStock);
        if (stock.getCantidadDisponible() < cantidad) {
            throw new StockInsuficienteException(idStock);
        }
        stock.reducir(cantidad);
        stockRepository.actualizar(stock);
    }

    public void aumentarStock(String idStock, int cantidad) {
        Stock stock = buscarStock(idStock);
        stock.aumentar(cantidad);
        stockRepository.actualizar(stock);
    }

    public List<Stock> listarBajoStock() {
        List<Stock> resultado = new java.util.ArrayList<>();
        for (Stock s : stockRepository.listarTodos()) {
            if (s.hayDesabastecimiento()) {
                resultado.add(s);
            }
        }
        return resultado;
    }
}