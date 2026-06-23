package Model.repositorios;

import Model.entidades.Lote;

import java.util.List;

public interface ILoteRepository {
    void agregar(Lote lote);
    Lote buscarPorId(String idLote);
    List<Lote> listarTodos();
    void actualizar(Lote lote);
    void eliminar(String idLote);
}