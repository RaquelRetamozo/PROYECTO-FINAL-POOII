import Model.Contexto;
import Model.entidades.Usuario;
import Model.servicios.*;
import controller.*;
import view.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Contexto compartido
        Contexto ctx = Contexto.getInstancia();

        // Servicios
        InventarioService inventarioService = new InventarioService(ctx.getProductoRepo());
        StockService stockService = new StockService(ctx.getStockRepo());
        LoteService loteService = new LoteService(ctx.getLoteRepo());
        TrazabilidadService trazabilidadService = new TrazabilidadService(ctx.getDespachoRepo(), ctx.getMovimientoRepo());
        DespachoService despachoService = new DespachoService(ctx.getDespachoRepo());
        MonitoreoAmbientalService monitoreoService = new MonitoreoAmbientalService(ctx.getSensorRepo());
        AlertaAmbientalService alertaAmbientalService = new AlertaAmbientalService();
        AlertaVencimientoService alertaVencimientoService = new AlertaVencimientoService(ctx.getLoteRepo(), 30);
        AlertaDesabastecimientoService alertaDesabastecimientoService = new AlertaDesabastecimientoService(ctx.getStockRepo());
        NoConformidadService noConformidadService = new NoConformidadService(ctx.getNoConformidadRepo());
        ReclamoService reclamoService = new ReclamoService(ctx.getReclamoRepo());
        ReporteService reporteService = new ReporteService(ctx.getStockRepo(), ctx.getDespachoRepo(), ctx.getNoConformidadRepo(), ctx.getReclamoRepo(), ctx.getMovimientoRepo());
        EstadisticaService estadisticaService = new EstadisticaService(ctx.getStockRepo(), ctx.getDespachoRepo());
        UsuarioService usuarioService = new UsuarioService(ctx.getUsuarioRepo());
        AutenticacionService autenticacionService = new AutenticacionService(ctx.getUsuarioRepo());
        ClienteService clienteService = new ClienteService(ctx.getClienteRepo());

        // Controllers
        InventarioController inventarioController = new InventarioController(inventarioService);
        StockController stockController = new StockController(stockService);
        LoteController loteController = new LoteController(loteService);
        TrazabilidadController trazabilidadController = new TrazabilidadController(trazabilidadService);
        DespachoController despachoController = new DespachoController(despachoService);
        ClienteController clienteController = new ClienteController(ctx.getClienteRepo());
        MonitoreoController monitoreoController = new MonitoreoController(monitoreoService);
        AlertaController alertaController = new AlertaController(alertaVencimientoService, alertaDesabastecimientoService, alertaAmbientalService);
        NoConformidadController noConformidadController = new NoConformidadController(noConformidadService);
        ReclamoController reclamoController = new ReclamoController(reclamoService);
        ReporteController reporteController = new ReporteController(reporteService);
        EstadisticaController estadisticaController = new EstadisticaController(estadisticaService);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        AutenticacionController autenticacionController = new AutenticacionController(autenticacionService);

        // Vistas
        LoginVista loginVista = new LoginVista();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        InventarioVista inventarioVista = new InventarioVista();
        StockVista stockVista = new StockVista();
        AlertaVista alertaVista = new AlertaVista();
        LoteVista loteVista = new LoteVista();
        DespachoVista despachoVista = new DespachoVista();
        ClienteVista clienteVista = new ClienteVista();
        TrazabilidadVista trazabilidadVista = new TrazabilidadVista();
        MonitoreoAmbientalVista monitoreoVista = new MonitoreoAmbientalVista();
        NoConformidadVista noConformidadVista = new NoConformidadVista();
        ReclamoVista reclamoVista = new ReclamoVista();
        ReporteVista reporteVista = new ReporteVista();
        EstadisticaVista estadisticaVista = new EstadisticaVista();
        UsuarioVista usuarioVista = new UsuarioVista();
        DashboardVista dashboardVista = new DashboardVista();

        // Usuario de prueba
        ctx.getUsuarioRepo().agregar(new Usuario("U001", "Admin", "Cramer",
                "admin@cramer.com", "1234", "ADMINISTRADOR"));

        // Login
        boolean sesionIniciada = false;
        while (!sesionIniciada) {
            try {
                loginVista.mostrarBienvenida();
                String email = loginVista.pedirEmail();
                String password = loginVista.pedirPassword();
                autenticacionController.iniciarSesion(email, password);
                sesionIniciada = true;
            } catch (Exception e) {
                loginVista.mostrarErrorLogin();
            }
        }

        // Menu principal
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("\n========================================");
                System.out.println("   SISTEMA DE GESTIÓN - CRAMER PERÚ");
                System.out.println("========================================");
                System.out.println("1. Módulo 1: Gestión de Inventarios");
                System.out.println("2. Módulo 2: Trazabilidad de Lotes");
                System.out.println("3. Módulo 3: Monitoreo Ambiental");
                System.out.println("0. Salir");
                System.out.print("Seleccione: ");
                Scanner scanner = new Scanner(System.in);
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        // Módulo 1: Gestión de Inventarios
                        boolean salirMod1 = false;
                        while (!salirMod1) {
                            System.out.println("\n=== MÓDULO 1: GESTIÓN DE INVENTARIOS ===");
                            System.out.println("1. Gestión de Productos");
                            System.out.println("2. Gestión de Stock");
                            System.out.println("3. Alertas");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op1 = Integer.parseInt(scanner.nextLine());
                            switch (op1) {
                                case 1:
                                    boolean salirProd = false;
                                    while (!salirProd) {
                                        int op = inventarioVista.mostrarMenu();
                                        if (op == 0) salirProd = true;
                                        else if (op == 1) {
                                            String[] datos = inventarioVista.pedirDatosProducto();
                                            // registrar producto via factory
                                        }
                                        else if (op == 3) inventarioVista.mostrarListaProductos(inventarioController.listarProductos());
                                        else if (op == 5) {
                                            String id = inventarioVista.pedirIdProducto();
                                            inventarioController.eliminarProducto(id);
                                        }
                                    }
                                    break;
                                case 2:
                                    boolean salirStock = false;
                                    while (!salirStock) {
                                        int op = stockVista.mostrarMenu();
                                        if (op == 0) salirStock = true;
                                        else if (op == 3) stockVista.mostrarListaStocks(stockController.listarStocks());
                                        else if (op == 6) stockVista.mostrarListaStocks(stockController.listarBajoStock());
                                    }
                                    break;
                                case 3:
                                    boolean salirAlerta = false;
                                    while (!salirAlerta) {
                                        int op = alertaVista.mostrarMenu();
                                        if (op == 0) salirAlerta = true;
                                        else if (op == 1) alertaVista.mostrarLotesProximosAVencer(alertaController.listarLotesProximosAVencer());
                                        else if (op == 2) alertaVista.mostrarLotesVencidos(alertaController.listarLotesVencidos());
                                        else if (op == 3) alertaVista.mostrarStockCritico(alertaController.listarStockCritico());
                                    }
                                    break;
                                case 0:
                                    salirMod1 = true;
                                    break;
                            }
                        }
                        break;

                    case 2:
                        // Módulo 2: Trazabilidad de Lotes
                        boolean salirMod2 = false;
                        while (!salirMod2) {
                            System.out.println("\n=== MÓDULO 2: TRAZABILIDAD DE LOTES ===");
                            System.out.println("1. Gestión de Lotes");
                            System.out.println("2. Gestión de Despachos");
                            System.out.println("3. Gestión de Clientes");
                            System.out.println("4. Trazabilidad");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op2 = Integer.parseInt(scanner.nextLine());
                            switch (op2) {
                                case 1:
                                    boolean salirLote = false;
                                    while (!salirLote) {
                                        int op = loteVista.mostrarMenu();
                                        if (op == 0) salirLote = true;
                                        else if (op == 3) loteVista.mostrarListaLotes(loteController.listarLotes());
                                        else if (op == 4) loteVista.mostrarListaLotes(loteController.listarLotesVencidos());
                                        else if (op == 5) loteVista.mostrarListaLotes(loteController.listarLotesActivos());
                                    }
                                    break;
                                case 2:
                                    boolean salirDesp = false;
                                    while (!salirDesp) {
                                        int op = despachoVista.mostrarMenu();
                                        if (op == 0) salirDesp = true;
                                        else if (op == 3) despachoVista.mostrarListaDespachos(despachoController.listarDespachos());
                                        else if (op == 5) despachoVista.mostrarListaDespachos(despachoController.listarPendientes());
                                    }
                                    break;
                                case 3:
                                    boolean salirCli = false;
                                    while (!salirCli) {
                                        int op = clienteVista.mostrarMenu();
                                        if (op == 0) salirCli = true;
                                        else if (op == 3) clienteVista.mostrarListaClientes(clienteController.listarClientes());
                                    }
                                    break;
                                case 4:
                                    boolean salirTraz = false;
                                    while (!salirTraz) {
                                        int op = trazabilidadVista.mostrarMenu();
                                        if (op == 0) salirTraz = true;
                                        else if (op == 1) trazabilidadVista.mostrarDespachos(trazabilidadController.buscarPorLote(trazabilidadVista.pedirNumeroLote()));
                                        else if (op == 2) trazabilidadVista.mostrarDespachos(trazabilidadController.buscarPorCliente(trazabilidadVista.pedirIdCliente()));
                                        else if (op == 4) trazabilidadVista.mostrarMovimientos(trazabilidadController.listarMovimientos());
                                    }
                                    break;
                                case 0:
                                    salirMod2 = true;
                                    break;
                            }
                        }
                        break;

                    case 3:
                        // Módulo 3: Monitoreo Ambiental
                        boolean salirMod3 = false;
                        while (!salirMod3) {
                            System.out.println("\n=== MÓDULO 3: MONITOREO AMBIENTAL ===");
                            System.out.println("1. Monitoreo de Sensores");
                            System.out.println("2. No Conformidades");
                            System.out.println("3. Reclamos");
                            System.out.println("4. Reportes");
                            System.out.println("5. Dashboard");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op3 = Integer.parseInt(scanner.nextLine());
                            switch (op3) {
                                case 1:
                                    boolean salirMon = false;
                                    while (!salirMon) {
                                        int op = monitoreoVista.mostrarMenu();
                                        if (op == 0) salirMon = true;
                                        else if (op == 2) monitoreoVista.mostrarListaLecturas(monitoreoController.listarLecturas());
                                        else if (op == 3) monitoreoVista.mostrarListaLecturas(monitoreoController.listarLecturasFueraRango());
                                    }
                                    break;
                                case 2:
                                    boolean salirNc = false;
                                    while (!salirNc) {
                                        int op = noConformidadVista.mostrarMenu();
                                        if (op == 0) salirNc = true;
                                        else if (op == 3) noConformidadVista.mostrarListaNoConformidades(noConformidadController.listarTodas());
                                        else if (op == 4) noConformidadVista.mostrarListaNoConformidades(noConformidadController.listarCriticas());
                                    }
                                    break;
                                case 3:
                                    boolean salirRec = false;
                                    while (!salirRec) {
                                        int op = reclamoVista.mostrarMenu();
                                        if (op == 0) salirRec = true;
                                        else if (op == 3) reclamoVista.mostrarListaReclamos(reclamoController.listarTodos());
                                        else if (op == 4) reclamoVista.mostrarListaReclamos(reclamoController.listarPendientes());
                                    }
                                    break;
                                case 4:
                                    boolean salirRep = false;
                                    while (!salirRep) {
                                        int op = reporteVista.mostrarMenu();
                                        if (op == 0) salirRep = true;
                                        else if (op == 1) reporteVista.mostrarReporteInventario(reporteController.generarReporteInventario(autenticacionController.getUsuarioActivo().getNombreCompleto()));
                                        else if (op == 2) reporteVista.mostrarReporteDespachos(reporteController.generarReporteDespachos(autenticacionController.getUsuarioActivo().getNombreCompleto()));
                                        else if (op == 3) reporteVista.mostrarReporteCalidad(reporteController.generarReporteCalidad(autenticacionController.getUsuarioActivo().getNombreCompleto()));
                                    }
                                    break;
                                case 5:
                                    dashboardVista.mostrarDashboard(
                                            estadisticaController.getTotalProductosEnStock(),
                                            estadisticaController.getMontoTotalDespachos(),
                                            estadisticaController.getTotalDespachosEntregados(),
                                            estadisticaController.getTotalStockCritico()
                                    );
                                    break;
                                case 0:
                                    salirMod3 = true;
                                    break;
                            }
                        }
                        break;

                    case 0:
                        autenticacionController.cerrarSesion();
                        loginVista.mostrarSesionCerrada();
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        }
    }
}