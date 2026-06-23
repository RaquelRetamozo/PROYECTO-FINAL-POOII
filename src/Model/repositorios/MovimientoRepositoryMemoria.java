package Model.repositorios;

import Model.entidades.MovimientoInventario;
import java.util.ArrayList;
import java.util.List;

public class MovimientoRepositoryMemoria implements IMovimientoRepository {

    //Atributos
    private List<MovimientoInventario> movimientos;

    //Constructor
    public MovimientoRepositoryMemoria() {
        this.movimientos = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(MovimientoInventario movimiento) {
        movimientos.add(movimiento);
    }

    @Override
    public MovimientoInventario buscarPorId(String idMovimiento) {
        for (MovimientoInventario m : movimientos) {
            if (m.getIdMovimiento().equals(idMovimiento)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<MovimientoInventario> listarTodos() {
        return movimientos;
    }

    @Override
    public void actualizar(MovimientoInventario movimiento) {
        for (int i = 0; i < movimientos.size(); i++) {
            if (movimientos.get(i).getIdMovimiento().equals(movimiento.getIdMovimiento())) {
                movimientos.set(i, movimiento);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idMovimiento) {
        movimientos.removeIf(m -> m.getIdMovimiento().equals(idMovimiento));
    }
}