package view;

import java.util.Scanner;

public class EstadisticaVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public EstadisticaVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("1. Total productos en stock");
        System.out.println("2. Monto total despachos");
        System.out.println("3. Total despachos entregados");
        System.out.println("4. Total stock critico");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarEstadistica(String nombre, Object valor) {
        System.out.println(nombre + ": " + valor);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
