package Model.repositorios;
import Model.entidades.NoConformidad;
import java.util.ArrayList;
import java.util.List;

public class NoConformidadRepositoryMemoria implements INoConformidadRepository {

    //Atributos
    private List<NoConformidad> noConformidades;

    //Constructor
    public NoConformidadRepositoryMemoria() {
        this.noConformidades = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(NoConformidad noConformidad) {
        noConformidades.add(noConformidad);
    }

    @Override
    public NoConformidad buscarPorId(String idNoConformidad) {
        for (NoConformidad n : noConformidades) {
            if (n.getIdNoConformidad().equals(idNoConformidad)) {
                return n;
            }
        }
        return null;
    }

    @Override
    public List<NoConformidad> listarTodos() {
        return noConformidades;
    }

    @Override
    public void actualizar(NoConformidad noConformidad) {
        for (int i = 0; i < noConformidades.size(); i++) {
            if (noConformidades.get(i).getIdNoConformidad().equals(noConformidad.getIdNoConformidad())) {
                noConformidades.set(i, noConformidad);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idNoConformidad) {
        noConformidades.removeIf(n -> n.getIdNoConformidad().equals(idNoConformidad));
    }
}