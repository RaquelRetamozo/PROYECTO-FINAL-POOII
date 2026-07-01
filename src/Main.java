import Model.Contexto;
import Model.entidades.Cliente;
import Model.entidades.Despacho;
import Model.entidades.DetalleDespacho;
import Model.entidades.LecturaHumedad;
import Model.entidades.LecturaSensor;
import Model.entidades.LecturaTemperatura;
import Model.entidades.Lote;
import Model.entidades.NoConformidad;
import Model.entidades.Producto;
import Model.entidades.Reclamo;
import Model.entidades.Stock;
import Model.entidades.Transportista;
import Model.entidades.Usuario;
import Model.entidades.ZonaAlmacen;
import Model.patrones.factory.ProductoFactory;
import Model.servicios.*;
import controller.*;
import view.*;
import view.modulo1.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

        // Scanner
        Scanner scanner = new Scanner(System.in);

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
                System.out.println("1. Módulo 0: Registro Base (Productos y Clientes)");
                System.out.println("2. Módulo 1: Gestión de Inventario");
                System.out.println("3. Módulo 2: Trazabilidad de Lotes");
                System.out.println("4. Módulo 3: Monitoreo Ambiental");
                System.out.println("0. Salir");
                System.out.print("Seleccione: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        boolean salirMod0 = false;
                        while (!salirMod0) {
                            System.out.println("\n=== MÓDULO 0: REGISTRO BASE ===");
                            System.out.println("1. Gestión de Productos");
                            System.out.println("2. Gestión de Clientes");
                            System.out.println("3. Gestión de Lotes");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op0 = Integer.parseInt(scanner.nextLine());
                            switch (op0) {
                                case 1:
                                    boolean salirProd = false;
                                    while (!salirProd) {
                                        int op = inventarioVista.mostrarMenu();
                                        if (op == 0) salirProd = true;
                                        else if (op == 1) {
                                            String[] datos = inventarioVista.pedirDatosProducto();
                                            Producto p = ProductoFactory.crear(
                                                    datos[2], datos[0], datos[1],
                                                    LocalDate.parse(datos[3]), LocalDate.parse(datos[4]),
                                                    Double.parseDouble(datos[5]), datos[6],
                                                    Double.parseDouble(datos[7]));
                                            inventarioController.registrarProducto(p);
                                            inventarioVista.mostrarExito("Producto registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = inventarioVista.pedirIdProducto();
                                            inventarioVista.mostrarProducto(inventarioController.buscarProducto(id));
                                        }
                                        else if (op == 3) inventarioVista.mostrarListaProductos(inventarioController.listarProductos());
                                        else if (op == 4) {
                                            String[] datos = inventarioVista.pedirDatosProducto();
                                            Producto p = ProductoFactory.crear(
                                                    datos[2], datos[0], datos[1],
                                                    LocalDate.parse(datos[3]), LocalDate.parse(datos[4]),
                                                    Double.parseDouble(datos[5]), datos[6],
                                                    Double.parseDouble(datos[7]));
                                            inventarioController.actualizarProducto(p);
                                            inventarioVista.mostrarExito("Producto actualizado.");
                                        }
                                        else if (op == 5) {
                                            String id = inventarioVista.pedirIdProducto();
                                            inventarioController.eliminarProducto(id);
                                            inventarioVista.mostrarExito("Producto eliminado.");
                                        }
                                    }
                                    break;
                                case 2:
                                    boolean salirCli = false;
                                    while (!salirCli) {
                                        int op = clienteVista.mostrarMenu();
                                        if (op == 0) salirCli = true;
                                        else if (op == 1) {
                                            String[] datos = clienteVista.pedirDatosCliente();
                                            Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                                            clienteController.registrarCliente(cliente);
                                            clienteVista.mostrarExito("Cliente registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = clienteVista.pedirIdCliente();
                                            clienteVista.mostrarCliente(clienteController.buscarCliente(id));
                                        }
                                        else if (op == 3) clienteVista.mostrarListaClientes(clienteController.listarClientes());
                                        else if (op == 4) {
                                            String[] datos = clienteVista.pedirDatosCliente();
                                            Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                                            clienteController.actualizarCliente(cliente);
                                            clienteVista.mostrarExito("Cliente actualizado.");
                                        }
                                        else if (op == 5) {
                                            String id = clienteVista.pedirIdCliente();
                                            clienteController.eliminarCliente(id);
                                            clienteVista.mostrarExito("Cliente eliminado.");
                                        }
                                    }
                                    break;
                                case 3:
                                    boolean salirLote = false;
                                    while (!salirLote) {
                                        int op = loteVista.mostrarMenu();
                                        if (op == 0) salirLote = true;
                                        else if (op == 1) {
                                            inventarioVista.mostrarListaProductos(inventarioController.listarProductos());
                                            String[] datos = loteVista.pedirDatosLote();
                                            Producto productoLote = inventarioController.buscarProducto(datos[2]);
                                            Lote lote = new Lote(datos[0], datos[1], productoLote,
                                                    Integer.parseInt(datos[3]), LocalDate.now(), datos[4], "ACTIVO");
                                            loteController.registrarLote(lote);
                                            loteVista.mostrarExito("Lote registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = loteVista.pedirIdLote();
                                            loteVista.mostrarLote(loteController.buscarLote(id));
                                        }
                                        else if (op == 3) loteVista.mostrarListaLotes(loteController.listarLotes());
                                        else if (op == 4) loteVista.mostrarListaLotes(loteController.listarLotesVencidos());
                                        else if (op == 5) loteVista.mostrarListaLotes(loteController.listarLotesActivos());
                                    }
                                    break;
                                case 0:
                                    salirMod0 = true;
                                    break;
                            }
                        }
                        break;

                    case 2:
                        boolean salirMod1 = false;
                        while (!salirMod1) {
                            System.out.println("\n=== INTERFAZ DEL MÓDULO 1: GESTIÓN DE INVENTARIO ===");
                            System.out.println("1. Gestión de Stock");
                            System.out.println("2. Alertas");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op1 = Integer.parseInt(scanner.nextLine());
                            switch (op1) {
                                case 1:
                                    boolean salirStock = false;
                                    while (!salirStock) {
                                        int op = stockVista.mostrarMenu();
                                        if (op == 0) salirStock = true;
                                        else if (op == 1) {
                                            loteVista.mostrarListaLotes(loteController.listarLotes());
                                            String[] datos = stockVista.pedirDatosStock();
                                            Lote loteStock = loteController.buscarLote(datos[1]);
                                            Stock stock = new Stock(datos[0], loteStock,
                                                    Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), LocalDate.now());
                                            stockController.registrarStock(stock);
                                            stockVista.mostrarExito("Stock registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = stockVista.pedirIdStock();
                                            stockVista.mostrarStock(stockController.buscarStock(id));
                                        }
                                        else if (op == 3) stockVista.mostrarListaStocks(stockController.listarStocks());
                                        else if (op == 4) {
                                            String id = stockVista.pedirIdStock();
                                            int cantidad = stockVista.pedirCantidad();
                                            stockController.reducirStock(id, cantidad);
                                            stockVista.mostrarExito("Stock reducido.");
                                        }
                                        else if (op == 5) {
                                            String id = stockVista.pedirIdStock();
                                            int cantidad = stockVista.pedirCantidad();
                                            stockController.aumentarStock(id, cantidad);
                                            stockVista.mostrarExito("Stock aumentado.");
                                        }
                                        else if (op == 6) stockVista.mostrarListaStocks(stockController.listarBajoStock());
                                    }
                                    break;
                                case 2:
                                    boolean salirAlerta = false;
                                    while (!salirAlerta) {
                                        int op = alertaVista.mostrarMenu();
                                        if (op == 0) salirAlerta = true;
                                        else if (op == 1) alertaVista.mostrarLotesProximosAVencer(alertaController.listarLotesProximosAVencer());
                                        else if (op == 2) alertaVista.mostrarLotesVencidos(alertaController.listarLotesVencidos());
                                        else if (op == 3) alertaVista.mostrarStockCritico(alertaController.listarStockCritico());
                                        else if (op == 4) alertaVista.mostrarAlertasAmbientales(alertaController.listarAlertasAmbientales());
                                    }
                                    break;
                                case 0:
                                    salirMod1 = true;
                                    break;
                            }
                        }
                        break;

                    case 3:
                        boolean salirMod2 = false;
                        while (!salirMod2) {
                            System.out.println("\n=== INTERFAZ DEL MÓDULO 2: TRAZABILIDAD DE LOTES ===");
                            System.out.println("1. Gestión de Despachos");
                            System.out.println("2. Trazabilidad");
                            System.out.println("0. Volver");
                            System.out.print("Seleccione: ");
                            int op2 = Integer.parseInt(scanner.nextLine());
                            switch (op2) {
                                case 1:
                                    boolean salirDesp = false;
                                    while (!salirDesp) {
                                        int op = despachoVista.mostrarMenu();
                                        if (op == 0) salirDesp = true;
                                        else if (op == 1) {
                                            clienteVista.mostrarListaClientes(clienteController.listarClientes());
                                            String[] datos = despachoVista.pedirDatosDespacho();
                                            Cliente clienteDesp = clienteController.buscarCliente(datos[1]);
                                            Transportista transportista = new Transportista(datos[2], datos[2], "", "", "", "", "");
                                            Despacho despacho = new Despacho(datos[0], clienteDesp, transportista, LocalDate.now(), datos[3]);

                                            System.out.println("--- Agregar detalle del despacho (obligatorio al menos 1) ---");
                                            loteVista.mostrarListaLotes(loteController.listarLotes());
                                            System.out.print("ID Lote: ");
                                            String idLoteDet = scanner.nextLine();
                                            Lote loteDet = loteController.buscarLote(idLoteDet);
                                            System.out.print("Cantidad: ");
                                            int cantidadDet = Integer.parseInt(scanner.nextLine());
                                            System.out.print("Precio unitario: ");
                                            double precioDet = Double.parseDouble(scanner.nextLine());
                                            despacho.agregarDetalle(new DetalleDespacho("DET-" + datos[0], despacho, loteDet, cantidadDet, precioDet));

                                            despachoController.registrarDespacho(despacho);
                                            despachoVista.mostrarExito("Despacho registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = despachoVista.pedirIdDespacho();
                                            despachoVista.mostrarDespacho(despachoController.buscarDespacho(id));
                                        }
                                        else if (op == 3) despachoVista.mostrarListaDespachos(despachoController.listarDespachos());
                                        else if (op == 4) {
                                            String id = despachoVista.pedirIdDespacho();
                                            String nuevoEstado = despachoVista.pedirNuevoEstado();
                                            despachoController.actualizarEstado(id, nuevoEstado);
                                            despachoVista.mostrarExito("Estado actualizado.");
                                        }
                                        else if (op == 5) despachoVista.mostrarListaDespachos(despachoController.listarPendientes());
                                    }
                                    break;
                                case 2:
                                    boolean salirTraz = false;
                                    while (!salirTraz) {
                                        int op = trazabilidadVista.mostrarMenu();
                                        if (op == 0) salirTraz = true;
                                        else if (op == 1) trazabilidadVista.mostrarDespachos(trazabilidadController.buscarPorLote(trazabilidadVista.pedirNumeroLote()));
                                        else if (op == 2) trazabilidadVista.mostrarDespachos(trazabilidadController.buscarPorCliente(trazabilidadVista.pedirIdCliente()));
                                        else if (op == 3) trazabilidadVista.mostrarMovimientos(trazabilidadController.buscarMovimientosPorLote(trazabilidadVista.pedirIdLote()));
                                        else if (op == 4) trazabilidadVista.mostrarMovimientos(trazabilidadController.listarMovimientos());
                                    }
                                    break;
                                case 0:
                                    salirMod2 = true;
                                    break;
                            }
                        }
                        break;

                    case 4:
                        boolean salirMod3 = false;
                        while (!salirMod3) {
                            System.out.println("\n=== INTERFAZ DEL MÓDULO 3: MONITOREO AMBIENTAL ===");
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
                                        else if (op == 1) {
                                            String[] datos = monitoreoVista.pedirDatosLectura();
                                            String idSensor = datos[0];
                                            String tipo = datos[1].toUpperCase();
                                            double valor = Double.parseDouble(datos[2]);
                                            ZonaAlmacen zona = new ZonaAlmacen(datos[3], datos[3], 2, 8, 30, 70, "", new ArrayList<>());
                                            String idLectura = idSensor + "-" + System.currentTimeMillis();
                                            LecturaSensor lectura;
                                            if (tipo.equals("TEMPERATURA")) {
                                                lectura = new LecturaTemperatura(idLectura, idSensor, zona, valor, 2, 8);
                                            } else {
                                                lectura = new LecturaHumedad(idLectura, idSensor, zona, valor, 30, 70);
                                            }
                                            monitoreoController.registrarLectura(lectura);
                                            monitoreoVista.mostrarExito("Lectura registrada.");
                                        }
                                        else if (op == 2) monitoreoVista.mostrarListaLecturas(monitoreoController.listarLecturas());
                                        else if (op == 3) monitoreoVista.mostrarListaLecturas(monitoreoController.listarLecturasFueraRango());
                                    }
                                    break;
                                case 2:
                                    boolean salirNc = false;
                                    while (!salirNc) {
                                        int op = noConformidadVista.mostrarMenu();
                                        if (op == 0) salirNc = true;
                                        else if (op == 1) {
                                            loteVista.mostrarListaLotes(loteController.listarLotes());
                                            String[] datos = noConformidadVista.pedirDatosNoConformidad();
                                            Lote loteNc = loteController.buscarLote(datos[5]);
                                            NoConformidad nc = new NoConformidad(datos[0], datos[1], datos[2], datos[3], datos[4], loteNc);
                                            noConformidadController.registrarNoConformidad(nc);
                                            noConformidadVista.mostrarExito("No conformidad registrada.");
                                        }
                                        else if (op == 2) {
                                            String id = noConformidadVista.pedirIdNoConformidad();
                                            noConformidadVista.mostrarNoConformidad(noConformidadController.buscarNoConformidad(id));
                                        }
                                        else if (op == 3) noConformidadVista.mostrarListaNoConformidades(noConformidadController.listarTodas());
                                        else if (op == 4) noConformidadVista.mostrarListaNoConformidades(noConformidadController.listarCriticas());
                                        else if (op == 5) {
                                            String id = noConformidadVista.pedirIdNoConformidad();
                                            noConformidadController.cerrarNoConformidad(id);
                                            noConformidadVista.mostrarExito("No conformidad cerrada.");
                                        }
                                    }
                                    break;
                                case 3:
                                    boolean salirRec = false;
                                    while (!salirRec) {
                                        int op = reclamoVista.mostrarMenu();
                                        if (op == 0) salirRec = true;
                                        else if (op == 1) {
                                            clienteVista.mostrarListaClientes(clienteController.listarClientes());
                                            loteVista.mostrarListaLotes(loteController.listarLotes());
                                            String[] datos = reclamoVista.pedirDatosReclamo();
                                            Cliente clienteRec = clienteController.buscarCliente(datos[1]);
                                            Lote loteRec = loteController.buscarLote(datos[2]);
                                            Reclamo reclamo = new Reclamo(datos[0], clienteRec, loteRec, datos[3], datos[4], datos[5]);
                                            reclamoController.registrarReclamo(reclamo);
                                            reclamoVista.mostrarExito("Reclamo registrado.");
                                        }
                                        else if (op == 2) {
                                            String id = reclamoVista.pedirIdReclamo();
                                            reclamoVista.mostrarReclamo(reclamoController.buscarReclamo(id));
                                        }
                                        else if (op == 3) reclamoVista.mostrarListaReclamos(reclamoController.listarTodos());
                                        else if (op == 4) reclamoVista.mostrarListaReclamos(reclamoController.listarPendientes());
                                        else if (op == 5) {
                                            String id = reclamoVista.pedirIdReclamo();
                                            reclamoController.resolverReclamo(id);
                                            reclamoVista.mostrarExito("Reclamo resuelto.");
                                        }
                                        else if (op == 6) {
                                            String id = reclamoVista.pedirIdReclamo();
                                            reclamoController.cerrarReclamo(id);
                                            reclamoVista.mostrarExito("Reclamo cerrado.");
                                        }
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
        scanner.close();
    }
}