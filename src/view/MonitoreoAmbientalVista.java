package view;

import Model.entidades.LecturaSensor;
import java.util.List;
import java.util.Scanner;

public class MonitoreoAmbientalVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public MonitoreoAmbientalVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== MONITOREO AMBIENTAL ===");
        System.out.println("1. Registrar lectura");
        System.out.println("2. Listar lecturas");
        System.out.println("3. Listar lecturas fuera de rango");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosLectura() {
        System.out.print("ID Sensor: ");
        String idSensor = scanner.nextLine();
        System.out.print("Tipo (TEMPERATURA/HUMEDAD): ");
        String tipo = scanner.nextLine();
        System.out.print("Valor: ");
        String valor = scanner.nextLine();
        System.out.print("ID Zona: ");
        String idZona = scanner.nextLine();
        return new String[]{idSensor, tipo, valor, idZona};
    }

    public void mostrarLectura(LecturaSensor lectura) {
        System.out.println("\n--- LECTURA ---");
        System.out.println("ID: " + lectura.getIdLectura());
        System.out.println("Sensor: " + lectura.getIdSensor());
        System.out.println("Zona: " + lectura.getZona().getNombre());
        System.out.println("Valor: " + lectura.getValor());
        System.out.println("Fecha: " + lectura.getFechaHora());
        System.out.println("Estado: " + (lectura.isDentroRango() ? "OK" : "⚠ FUERA DE RANGO"));
    }

    public void mostrarListaLecturas(List<LecturaSensor> lecturas) {
        System.out.println("\n--- LISTA DE LECTURAS ---");
        if (lecturas.isEmpty()) {
            System.out.println("No hay lecturas registradas.");
            return;
        }
        for (LecturaSensor l : lecturas) {
            System.out.println("ID: " + l.getIdLectura() +
                    " | Sensor: " + l.getIdSensor() +
                    " | Zona: " + l.getZona().getNombre() +
                    " | Valor: " + l.getValor() +
                    " | Estado: " + (l.isDentroRango() ? "OK" : "⚠ FUERA DE RANGO"));
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
