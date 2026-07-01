package Model;

import Model.repositorios.*;

public class Contexto {

    //Atributos
    private static Contexto instancia;
    private IProductoRepository productoRepo;
    private ILoteRepository loteRepo;
    private IStockRepository stockRepo;
    private IDespachoRepository despachoRepo;
    private IClienteRepository clienteRepo;
    private IMovimientoRepository movimientoRepo;
    private ISensorRepository sensorRepo;
    private INoConformidadRepository noConformidadRepo;
    private IReclamoRepository reclamoRepo;
    private IUsuarioRepository usuarioRepo;

    //Constructor
    private Contexto() {
        productoRepo = new ProductoRepositoryMemoria();
        loteRepo = new LoteRepositoryMemoria();
        stockRepo = new StockRepositoryMemoria();
        despachoRepo = new DespachoRepositoryMemoria();
        clienteRepo = new ClienteRepositoryMemoria();
        movimientoRepo = new MovimientoRepositoryMemoria();
        sensorRepo = new SensorRepositoryMemoria();
        noConformidadRepo = new NoConformidadRepositoryMemoria();
        reclamoRepo = new ReclamoRepositoryMemoria();
        usuarioRepo = new UsuarioRepositoryMemoria();
    }

    //Métodos
    public static Contexto getInstancia() {
        if (instancia == null) {
            instancia = new Contexto();
        }
        return instancia;
    }

    //Getters
    public IProductoRepository getProductoRepo() { return productoRepo; }
    public ILoteRepository getLoteRepo() { return loteRepo; }
    public IStockRepository getStockRepo() { return stockRepo; }
    public IDespachoRepository getDespachoRepo() { return despachoRepo; }
    public IClienteRepository getClienteRepo() { return clienteRepo; }
    public IMovimientoRepository getMovimientoRepo() { return movimientoRepo; }
    public ISensorRepository getSensorRepo() { return sensorRepo; }
    public INoConformidadRepository getNoConformidadRepo() { return noConformidadRepo; }
    public IReclamoRepository getReclamoRepo() { return reclamoRepo; }
    public IUsuarioRepository getUsuarioRepo() { return usuarioRepo; }
}