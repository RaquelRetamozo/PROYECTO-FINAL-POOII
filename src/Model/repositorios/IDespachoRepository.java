package Model.repositorios;

import Model.entidades.Despacho;
import java.util.List;

public interface IDespachoRepository {
    void agregar(Despacho despacho);
    Despacho buscarPorId(String idDespacho);
    List<Despacho> listarTodos();
    void actualizar(Despacho despacho);
    void eliminar(String idDespacho);
}