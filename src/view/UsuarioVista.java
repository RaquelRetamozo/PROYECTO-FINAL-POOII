package view;

import Model.entidades.Usuario;
import java.util.List;
import java.util.Scanner;

public class UsuarioVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public UsuarioVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== USUARIOS ===");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Buscar usuario");
        System.out.println("3. Listar usuarios");
        System.out.println("4. Actualizar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosUsuario() {
        System.out.print("ID Usuario: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Rol (ADMINISTRADOR/OPERARIO/GERENTE/AUDITOR): ");
        String rol = scanner.nextLine();
        return new String[]{id, nombre, apellido, email, password, rol};
    }

    public String pedirIdUsuario() {
        System.out.print("ID Usuario: ");
        return scanner.nextLine();
    }

    public void mostrarUsuario(Usuario usuario) {
        System.out.println("\n--- USUARIO ---");
        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombreCompleto());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Rol: " + usuario.getRol());
    }

    public void mostrarListaUsuarios(List<Usuario> usuarios) {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getIdUsuario() +
                    " | Nombre: " + u.getNombreCompleto() +
                    " | Rol: " + u.getRol());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}