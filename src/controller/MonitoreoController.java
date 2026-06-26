package controller;

import Model.entidades.LecturaHumedad;
import Model.entidades.LecturaSensor;
import Model.entidades.LecturaTemperatura;
import Model.servicios.MonitoreoAmbientalService;
import java.util.List;

public class MonitoreoController {

    //Atributos
    private MonitoreoAmbientalService monitoreoService;

    //Constructor
    public MonitoreoController(MonitoreoAmbientalService monitoreoService) {
        this.monitoreoService = monitoreoService;
    }

    //Métodos
    public void registrarLectura(LecturaSensor lectura) {
        monitoreoService.registrarLectura(lectura);
        System.out.println("Lectura registrada correctamente.");
    }

    public void verificarTemperatura(LecturaTemperatura lectura) {
        monitoreoService.verificarTemperatura(lectura);
    }

    public void verificarHumedad(LecturaHumedad lectura) {
        monitoreoService.verificarHumedad(lectura);
    }

    public List<LecturaSensor> listarLecturasFueraRango() {
        return monitoreoService.listarLecturasFueraRango();
    }

    public List<LecturaSensor> listarLecturas() {
        return monitoreoService.listarLecturas();
    }
}
