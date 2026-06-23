package Model.repositorios;

import Model.entidades.Stock;
import java.util.List;

public interface IStockRepository {
    void agregar(Stock stock);
    Stock buscarPorId(String idStock);
    List<Stock> listarTodos();
    void actualizar(Stock stock);
    void eliminar(String idStock);
}