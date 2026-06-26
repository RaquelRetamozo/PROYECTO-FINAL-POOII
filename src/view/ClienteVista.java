package view;

import Model.entidades.Cliente;
import java.util.List;
import java.util.Scanner;

public class ClienteVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public ClienteVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE CLIENTES ===");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Buscar cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosCliente() {
        System.out.print("ID Cliente: ");
        String id = scanner.nextLine();
        System.out.print("Razon social: ");
        String razonSocial = scanner.nextLine();
        System.out.print("RUC: ");
        String ruc = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();
        return new String[]{id, razonSocial, ruc, direccion, telefono, email, contacto};
    }

    public String pedirIdCliente() {
        System.out.print("ID Cliente: ");
        return scanner.nextLine();
    }

    public void mostrarCliente(Cliente cliente) {
        System.out.println("\n--- CLIENTE ---");
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Razon Social: " + cliente.getRazonSocial());
        System.out.println("RUC: " + cliente.getRuc());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Contacto: " + cliente.getContacto());
    }

    public void mostrarListaClientes(List<Cliente> clientes) {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getIdCliente() +
                    " | Razon Social: " + c.getRazonSocial() +
                    " | RUC: " + c.getRuc() +
                    " | Tel: " + c.getTelefono());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}