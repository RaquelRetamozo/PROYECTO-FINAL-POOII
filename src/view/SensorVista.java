package view;

import Model.entidades.LecturaSensor;
import java.util.List;
import java.util.Scanner;

public class SensorVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public SensorVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== SENSORES ===");
        System.out.println("1. Ver ultima lectura");
        System.out.println("2. Listar todas las lecturas");
        System.out.println("3. Listar lecturas fuera de rango");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirIdSensor() {
        System.out.print("ID Sensor: ");
        return scanner.nextLine();
    }

    public void mostrarLectura(LecturaSensor lectura) {
        System.out.println("\n--- LECTURA SENSOR ---");
        System.out.println("Sensor: " + lectura.getIdSensor());
        System.out.println("Tipo: " + lectura.getTipoLectura());
        System.out.println("Valor: " + lectura.getValor());
        System.out.println("Zona: " + lectura.getZona().getNombre());
        System.out.println("Fecha: " + lectura.getFechaHora());
        System.out.println("Estado: " + (lectura.isDentroRango() ? "OK" : "⚠ FUERA DE RANGO"));
    }

    public void mostrarListaLecturas(List<LecturaSensor> lecturas) {
        System.out.println("\n--- LECTURAS ---");
        if (lecturas.isEmpty()) {
            System.out.println("No hay lecturas.");
            return;
        }
        for (LecturaSensor l : lecturas) {
            System.out.println("Sensor: " + l.getIdSensor() +
                    " | Tipo: " + l.getTipoLectura() +
                    " | Valor: " + l.getValor() +
                    " | Estado: " + (l.isDentroRango() ? "OK" : "⚠ FUERA DE RANGO"));
        }
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
