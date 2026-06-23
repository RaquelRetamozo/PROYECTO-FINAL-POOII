package Model.excepciones;

public class ReporteVacioException extends CramerException {
    public ReporteVacioException(String tipoReporte) {
        super("El reporte de " + tipoReporte + " no contiene datos.");
    }
}