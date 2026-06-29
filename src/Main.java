import Model.Contexto;
import Model.entidades.Usuario;
import Model.servicios.*;
import controller.*;
import view.*;

import java.util.Scanner;

public class Main{

public static void Main(Strings){
    // Contexto Compartido
    Contexto ctx = Contexto.getInstancia();

    //Servicios
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

    {
}