package view;

import Model.entidades.Despacho;
import java.util.List;
import java.util.Scanner;

public class DespachoVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public DespachoVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE DESPACHOS ===");
        System.out.println("1. Registrar despacho");
        System.out.println("2. Buscar despacho");
        System.out.println("3. Listar despachos");
        System.out.println("4. Actualizar estado");
        System.out.println("5. Listar pendientes");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosDespacho() {
        System.out.print("ID Despacho: ");
        String id = scanner.nextLine();
        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("ID Transportista: ");
        String idTransportista = scanner.nextLine();
        System.out.print("Observacion: ");
        String observacion = scanner.nextLine();
        return new String[]{id, idCliente, idTransportista, observacion};
    }

    public String pedirIdDespacho() {
        System.out.print("ID Despacho: ");
        return scanner.nextLine();
    }

    public String pedirNuevoEstado() {
        System.out.println("Estados: PENDIENTE / EN_EJECUCION / ENTREGADO / TERMINADO");
        System.out.print("Nuevo estado: ");
        return scanner.nextLine();
    }

    public void mostrarDespacho(Despacho despacho) {
        System.out.println("\n--- DESPACHO ---");
        System.out.println("ID: " + despacho.getIdDespacho());
        System.out.println("Cliente: " + despacho.getCliente().getRazonSocial());
        System.out.println("Transportista: " + despacho.getTransportista().getNombre());
        System.out.println("Fecha: " + despacho.getFechaDespacho());
        System.out.println("Estado: " + despacho.getEstado());
        System.out.println("Total: S/." + despacho.getTotalDespacho());
    }

    public void mostrarListaDespachos(List<Despacho> despachos) {
        System.out.println("\n--- LISTA DE DESPACHOS ---");
        if (despachos.isEmpty()) {
            System.out.println("No hay despachos registrados.");
            return;
        }
        for (Despacho d : despachos) {
            System.out.println("ID: " + d.getIdDespacho() +
                    " | Cliente: " + d.getCliente().getRazonSocial() +
                    " | Fecha: " + d.getFechaDespacho() +
                    " | Estado: " + d.getEstado() +
                    " | Total: S/." + d.getTotalDespacho());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}