package Model.repositorios;
import Model.entidades.LecturaSensor;
import java.util.ArrayList;
import java.util.List;

public class SensorRepositoryMemoria implements ISensorRepository {

    //Atributos
    private List<LecturaSensor> lecturas;

    //Constructor
    public SensorRepositoryMemoria() {
        this.lecturas = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(LecturaSensor lectura) {
        lecturas.add(lectura);
    }

    @Override
    public LecturaSensor buscarPorId(String idLectura) {
        for (LecturaSensor l : lecturas) {
            if (l.getIdLectura().equals(idLectura)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<LecturaSensor> listarTodos() {
        return lecturas;
    }

    @Override
    public void actualizar(LecturaSensor lectura) {
        for (int i = 0; i < lecturas.size(); i++) {
            if (lecturas.get(i).getIdLectura().equals(lectura.getIdLectura())) {
                lecturas.set(i, lectura);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idLectura) {
        lecturas.removeIf(l -> l.getIdLectura().equals(idLectura));
    }
}