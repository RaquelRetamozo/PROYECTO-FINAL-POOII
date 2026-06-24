package Model.servicios;

import Model.entidades.LecturaHumedad;
import Model.entidades.LecturaSensor;
import Model.entidades.LecturaTemperatura;
import Model.entidades.ZonaAlmacen;
import Model.excepciones.HumedadFueraRangoException;
import Model.excepciones.TemperaturaFueraRangoException;
import Model.repositorios.ISensorRepository;
import java.util.ArrayList;
import java.util.List;

public class MonitoreoAmbientalService {

    //Atributos
    private ISensorRepository sensorRepository;

    //Constructor
    public MonitoreoAmbientalService(ISensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    //Métodos
    public void registrarLectura(LecturaSensor lectura) {
        sensorRepository.agregar(lectura);
    }

    public void verificarTemperatura(LecturaTemperatura lectura) {
        if (lectura.estaFueraDeRango()) {
            throw new TemperaturaFueraRangoException(lectura.getTemperaturaRegistrada());
        }
    }

    public void verificarHumedad(LecturaHumedad lectura) {
        if (lectura.estaFueraDeRango()) {
            throw new HumedadFueraRangoException(lectura.getHumedadRegistrada());
        }
    }

    public List<LecturaSensor> listarLecturasFueraRango() {
        List<LecturaSensor> resultado = new ArrayList<>();
        for (LecturaSensor l : sensorRepository.listarTodos()) {
            if (!l.isDentroRango()) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<LecturaSensor> listarLecturas() {
        return sensorRepository.listarTodos();
    }
}