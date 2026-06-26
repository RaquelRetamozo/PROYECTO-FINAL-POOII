package view;

import Model.entidades.NoConformidad;
import java.util.List;
import java.util.Scanner;

public class NoConformidadVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public NoConformidadVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== NO CONFORMIDADES ===");
        System.out.println("1. Registrar no conformidad");
        System.out.println("2. Buscar no conformidad");
        System.out.println("3. Listar todas");
        System.out.println("4. Listar criticas");
        System.out.println("5. Cerrar no conformidad");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosNoConformidad() {
        System.out.print("ID No Conformidad: ");
        String id = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Area: ");
        String area = scanner.nextLine();
        System.out.print("Nivel (LEVE/MODERADO/CRITICO): ");
        String nivel = scanner.nextLine();
        System.out.print("Responsable: ");
        String responsable = scanner.nextLine();
        System.out.print("ID Lote: ");
        String idLote = scanner.nextLine();
        return new String[]{id, descripcion, area, nivel, responsable, idLote};
    }

    public String pedirIdNoConformidad() {
        System.out.print("ID No Conformidad: ");
        return scanner.nextLine();
    }

    public void mostrarNoConformidad(NoConformidad nc) {
        System.out.println("\n--- NO CONFORMIDAD ---");
        System.out.println("ID: " + nc.getIdNoConformidad());
        System.out.println("Descripcion: " + nc.getDescripcion());
        System.out.println("Area: " + nc.getArea());
        System.out.println("Nivel: " + nc.getNivel());
        System.out.println("Estado: " + nc.getEstado());
        System.out.println("Fecha deteccion: " + nc.getFechaDeteccion());
        System.out.println("Responsable: " + nc.getResponsable());
        System.out.println("Lote: " + nc.getLote().getNumeroLote());
    }

    public void mostrarListaNoConformidades(List<NoConformidad> lista) {
        System.out.println("\n--- LISTA DE NO CONFORMIDADES ---");
        if (lista.isEmpty()) {
            System.out.println("No hay no conformidades registradas.");
            return;
        }
        for (NoConformidad nc : lista) {
            System.out.println("ID: " + nc.getIdNoConformidad() +
                    " | Nivel: " + nc.getNivel() +
                    " | Area: " + nc.getArea() +
                    " | Estado: " + nc.getEstado());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}