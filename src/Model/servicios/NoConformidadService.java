package Model.servicios;

import Model.entidades.AccionCorrectiva;
import Model.entidades.NoConformidad;
import Model.repositorios.INoConformidadRepository;
import java.util.ArrayList;
import java.util.List;

public class NoConformidadService {

    //Atributos
    private INoConformidadRepository noConformidadRepository;

    //Constructor
    public NoConformidadService(INoConformidadRepository noConformidadRepository) {
        this.noConformidadRepository = noConformidadRepository;
    }

    //Métodos
    public void registrarNoConformidad(NoConformidad noConformidad) {
        noConformidadRepository.agregar(noConformidad);
    }

    public NoConformidad buscarNoConformidad(String idNoConformidad) {
        NoConformidad nc = noConformidadRepository.buscarPorId(idNoConformidad);
        if (nc == null) {
            throw new RuntimeException("No conformidad no encontrada: " + idNoConformidad);
        }
        return nc;
    }

    public List<NoConformidad> listarTodas() {
        return noConformidadRepository.listarTodos();
    }

    public List<NoConformidad> listarCriticas() {
        List<NoConformidad> criticas = new ArrayList<>();
        for (NoConformidad nc : noConformidadRepository.listarTodos()) {
            if (nc.esCritica()) {
                criticas.add(nc);
            }
        }
        return criticas;
    }

    public void cerrarNoConformidad(String idNoConformidad) {
        NoConformidad nc = buscarNoConformidad(idNoConformidad);
        nc.cerrar();
        noConformidadRepository.actualizar(nc);
    }
}