package Model.patrones.singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoggerSistema {

    //Atributos
    private static LoggerSistema instancia;
    private List<String> logs;

    //Constructor
    private LoggerSistema() {
        this.logs = new ArrayList<>();
    }

    //Métodos
    public static LoggerSistema getInstancia() {
        if (instancia == null) {
            instancia = new LoggerSistema();
        }
        return instancia;
    }

    public void log(String mensaje) {
        String entrada = "[" + LocalDateTime.now() + "] " + mensaje;
        logs.add(entrada);
        System.out.println(entrada);
    }

    public void logError(String mensaje) {
        log("ERROR: " + mensaje);
    }

    public void logInfo(String mensaje) {
        log("INFO: " + mensaje);
    }

    public List<String> getLogs() { return logs; }

    public void limpiarLogs() { logs.clear(); }
}