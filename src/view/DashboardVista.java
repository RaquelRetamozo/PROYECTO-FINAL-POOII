package view;

public class DashboardVista {

    //Métodos
    public void mostrarDashboard(int totalProductos, double montoDespachos,
                                 int despachosEntregados, int stockCritico) {
        System.out.println("\n========================================");
        System.out.println("         DASHBOARD - CRAMER PERÚ");
        System.out.println("========================================");
        System.out.println("Total productos en stock : " + totalProductos);
        System.out.println("Monto total despachado   : S/." + montoDespachos);
        System.out.println("Despachos entregados     : " + despachosEntregados);
        System.out.println("Productos stock critico  : " + stockCritico);
        System.out.println("========================================");
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
