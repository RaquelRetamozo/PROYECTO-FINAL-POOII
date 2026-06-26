package view;

import java.util.Scanner;

public class MenuPrincipal {

    //Atributos
    private Scanner scanner;

    //Constructor
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE GESTIÓN - CRAMER PERÚ");
        System.out.println("========================================");
        System.out.println("1. Gestión de Inventario");
        System.out.println("2. Gestión de Lotes");
        System.out.println("3. Gestión de Stock");
        System.out.println("4. Trazabilidad");
        System.out.println("5. Despachos");
        System.out.println("6. Clientes");
        System.out.println("7. Monitoreo Ambiental");
        System.out.println("8. Alertas");
        System.out.println("9. No Conformidades");
        System.out.println("10. Reclamos");
        System.out.println("11. Reportes");
        System.out.println("12. Estadísticas");
        System.out.println("13. Usuarios");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
