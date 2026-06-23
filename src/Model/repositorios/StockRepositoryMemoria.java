package Model.repositorios;

import Model.entidades.Stock;
import java.util.ArrayList;
import java.util.List;

public class StockRepositoryMemoria implements IStockRepository {

    //Atributos
    private List<Stock> stocks;

    //Constructor
    public StockRepositoryMemoria() {
        this.stocks = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public Stock buscarPorId(String idStock) {
        for (Stock s : stocks) {
            if (s.getIdStock().equals(idStock)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Stock> listarTodos() {
        return stocks;
    }

    @Override
    public void actualizar(Stock stock) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getIdStock().equals(stock.getIdStock())) {
                stocks.set(i, stock);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idStock) {
        stocks.removeIf(s -> s.getIdStock().equals(idStock));
    }
}