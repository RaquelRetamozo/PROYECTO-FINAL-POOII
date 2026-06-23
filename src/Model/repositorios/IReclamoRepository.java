package Model.repositorios;
import Model.entidades.Reclamo;
import java.util.List;

public interface IReclamoRepository {
    void agregar(Reclamo reclamo);
    Reclamo buscarPorId(String idReclamo);
    List<Reclamo> listarTodos();
    void actualizar(Reclamo reclamo);
    void eliminar(String idReclamo);
}