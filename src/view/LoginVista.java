package view;

import java.util.Scanner;

public class LoginVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public LoginVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("   SISTEMA DE GESTIÓN - CRAMER PERÚ");
        System.out.println("========================================");
    }

    public String pedirEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    public String pedirPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }

    public void mostrarErrorLogin() {
        System.out.println("Email o contraseña incorrectos. Intente nuevamente.");
    }

    public void mostrarSesionCerrada() {
        System.out.println("Sesión cerrada. Hasta luego.");
    }
}