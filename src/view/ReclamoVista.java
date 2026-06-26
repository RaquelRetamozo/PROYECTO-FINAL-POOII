package view;

import Model.entidades.Reclamo;
import java.util.List;
import java.util.Scanner;

public class ReclamoVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public ReclamoVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== RECLAMOS ===");
        System.out.println("1. Registrar reclamo");
        System.out.println("2. Buscar reclamo");
        System.out.println("3. Listar todos");
        System.out.println("4. Listar pendientes");
        System.out.println("5. Resolver reclamo");
        System.out.println("6. Cerrar reclamo");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosReclamo() {
        System.out.print("ID Reclamo: ");
        String id = scanner.nextLine();
        System.out.print("ID Cliente: ");
        String idCliente = scanner.nextLine();
        System.out.print("ID Lote: ");
        String idLote = scanner.nextLine();
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Responsable: ");
        String responsable = scanner.nextLine();
        return new String[]{id, idCliente, idLote, motivo, descripcion, responsable};
    }

    public String pedirIdReclamo() {
        System.out.print("ID Reclamo: ");
        return scanner.nextLine();
    }

    public void mostrarReclamo(Reclamo reclamo) {
        System.out.println("\n--- RECLAMO ---");
        System.out.println("ID: " + reclamo.getIdReclamo());
        System.out.println("Cliente: " + reclamo.getCliente().getRazonSocial());
        System.out.println("Lote: " + reclamo.getLote().getNumeroLote());
        System.out.println("Motivo: " + reclamo.getMotivo());
        System.out.println("Estado: " + reclamo.getEstado());
        System.out.println("Fecha: " + reclamo.getFechaReclamo());
        System.out.println("Responsable: " + reclamo.getResponsable());
    }

    public void mostrarListaReclamos(List<Reclamo> reclamos) {
        System.out.println("\n--- LISTA DE RECLAMOS ---");
        if (reclamos.isEmpty()) {
            System.out.println("No hay reclamos registrados.");
            return;
        }
        for (Reclamo r : reclamos) {
            System.out.println("ID: " + r.getIdReclamo() +
                    " | Cliente: " + r.getCliente().getRazonSocial() +
                    " | Motivo: " + r.getMotivo() +
                    " | Estado: " + r.getEstado());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
