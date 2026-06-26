package view;

import java.util.Scanner;

public class AccionCorrectivaVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public AccionCorrectivaVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== ACCIONES CORRECTIVAS ===");
        System.out.println("1. Registrar accion correctiva");
        System.out.println("2. Cerrar accion correctiva");
        System.out.println("3. Ver acciones vencidas");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosAccion() {
        System.out.print("ID Accion: ");
        String id = scanner.nextLine();
        System.out.print("ID No Conformidad: ");
        String idNc = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Responsable: ");
        String responsable = scanner.nextLine();
        System.out.print("Fecha limite (YYYY-MM-DD): ");
        String fechaLimite = scanner.nextLine();
        return new String[]{id, idNc, descripcion, responsable, fechaLimite};
    }

    public String pedirIdAccion() {
        System.out.print("ID Accion: ");
        return scanner.nextLine();
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}