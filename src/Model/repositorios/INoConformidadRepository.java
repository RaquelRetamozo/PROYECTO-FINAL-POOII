package Model.repositorios;
import Model.entidades.NoConformidad;
import java.util.List;

public interface INoConformidadRepository {
    void agregar(NoConformidad noConformidad);
    NoConformidad buscarPorId(String idNoConformidad);
    List<NoConformidad> listarTodos();
    void actualizar(NoConformidad noConformidad);
    void eliminar(String idNoConformidad);
}