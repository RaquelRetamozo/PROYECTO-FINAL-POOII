package view;

import Model.entidades.Despacho;
import Model.entidades.MovimientoInventario;
import java.util.List;
import java.util.Scanner;

public class TrazabilidadVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public TrazabilidadVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== TRAZABILIDAD ===");
        System.out.println("1. Buscar despachos por lote");
        System.out.println("2. Buscar despachos por cliente");
        System.out.println("3. Buscar movimientos por lote");
        System.out.println("4. Listar movimientos");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirNumeroLote() {
        System.out.print("Numero de lote: ");
        return scanner.nextLine();
    }

    public String pedirIdCliente() {
        System.out.print("ID Cliente: ");
        return scanner.nextLine();
    }

    public String pedirIdLote() {
        System.out.print("ID Lote: ");
        return scanner.nextLine();
    }

    public void mostrarDespachos(List<Despacho> despachos) {
        System.out.println("\n--- DESPACHOS ENCONTRADOS ---");
        if (despachos.isEmpty()) {
            System.out.println("No se encontraron despachos.");
            return;
        }
        for (Despacho d : despachos) {
            System.out.println("ID: " + d.getIdDespacho() +
                    " | Cliente: " + d.getCliente().getRazonSocial() +
                    " | Fecha: " + d.getFechaDespacho() +
                    " | Estado: " + d.getEstado());
        }
    }

    public void mostrarMovimientos(List<MovimientoInventario> movimientos) {
        System.out.println("\n--- MOVIMIENTOS ---");
        if (movimientos.isEmpty()) {
            System.out.println("No se encontraron movimientos.");
            return;
        }
        for (MovimientoInventario m : movimientos) {
            System.out.println("ID: " + m.getIdMovimiento() +
                    " | Tipo: " + m.getTipoMovimiento() +
                    " | Cant: " + m.getCantidad() +
                    " | Fecha: " + m.getFechaHora() +
                    " | Responsable: " + m.getResponsable());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}