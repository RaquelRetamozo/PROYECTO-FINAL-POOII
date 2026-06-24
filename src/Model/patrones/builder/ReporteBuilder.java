package Model.patrones.builder;

import Model.entidades.Reporte;
import Model.entidades.ReporteCalidad;
import Model.entidades.ReporteDespachos;
import Model.entidades.ReporteInventario;
import Model.entidades.ReporteTrazabilidad;

public class ReporteBuilder {

    //Atributos
    private String idReporte;
    private String titulo;
    private String descripcion;
    private String generadoPor;
    private String tipo;

    //Constructor
    public ReporteBuilder() {
        this.descripcion = "";
    }

    //Métodos
    public ReporteBuilder idReporte(String idReporte) {
        this.idReporte = idReporte;
        return this;
    }

    public ReporteBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ReporteBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ReporteBuilder generadoPor(String generadoPor) {
        this.generadoPor = generadoPor;
        return this;
    }

    public ReporteBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Reporte build() {
        switch (tipo.toUpperCase()) {
            case "INVENTARIO":
                return new ReporteInventario(idReporte, titulo, descripcion, generadoPor);
            case "TRAZABILIDAD":
                return new ReporteTrazabilidad(idReporte, titulo, descripcion, generadoPor);
            case "CALIDAD":
                return new ReporteCalidad(idReporte, titulo, descripcion, generadoPor);
            case "DESPACHOS":
                return new ReporteDespachos(idReporte, titulo, descripcion, generadoPor);
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido: " + tipo);
        }
    }
}