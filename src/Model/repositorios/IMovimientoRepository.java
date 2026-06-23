package Model.repositorios;

import Model.entidades.MovimientoInventario;
import java.util.List;

public interface IMovimientoRepository {
    void agregar(MovimientoInventario movimiento);
    MovimientoInventario buscarPorId(String idMovimiento);
    List<MovimientoInventario> listarTodos();
    void actualizar(MovimientoInventario movimiento);
    void eliminar(String idMovimiento);
}