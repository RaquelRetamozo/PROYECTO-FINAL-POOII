package Model.repositorios;
import Model.entidades.LecturaSensor;
import java.util.List;

public interface ISensorRepository {
    void agregar(LecturaSensor lectura);
    LecturaSensor buscarPorId(String idLectura);
    List<LecturaSensor> listarTodos();
    void actualizar(LecturaSensor lectura);
    void eliminar(String idLectura);
}