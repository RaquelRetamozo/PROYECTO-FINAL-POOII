package Model.servicios;

import Model.entidades.LecturaSensor;
import Model.enums.TipoAlerta;
import java.util.ArrayList;
import java.util.List;

public class AlertaAmbientalService {

    //Atributos
    private List<String> alertas;

    //Constructor
    public AlertaAmbientalService() {
        this.alertas = new ArrayList<>();
    }

    //Métodos
    public void generarAlerta(LecturaSensor lectura, TipoAlerta tipo) {
        String mensaje = "ALERTA [" + tipo + "] - Sensor: " + lectura.getIdSensor() +
                " | Zona: " + lectura.getZona().getNombre() +
                " | Valor: " + lectura.getValor();
        alertas.add(mensaje);
        System.out.println(mensaje);
    }

    public List<String> listarAlertas() {
        return alertas;
    }

    public void limpiarAlertas() {
        alertas.clear();
    }
}