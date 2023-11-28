package icesi.edu.SID.SistemaVentas.controllers;

import icesi.edu.SID.SistemaVentas.models.mongodb.*;
import icesi.edu.SID.SistemaVentas.models.postgres.*;
import icesi.edu.SID.SistemaVentas.models.*;

import icesi.edu.SID.SistemaVentas.services.OrdenService;
import icesi.edu.SID.SistemaVentas.services.impl.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class SistemaVentasController {

    //------- Clientes -------
    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping("clientes")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los clientes
    @GetMapping("clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para obtener un cliente por ID
    @GetMapping("clientes/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar un cliente por ID
    @PutMapping("clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente nuevoCliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(id, nuevoCliente);
        return clienteActualizado != null
                ? new ResponseEntity<>(clienteActualizado, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para eliminar un cliente por ID
    @DeleteMapping("clientes/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //------- Detalles Clientes -------
    @Autowired
    private DetallesClienteServiceImpl detallesClienteService;

    // Endpoint para crear detalles de cliente
    @PostMapping("detalles-cliente")
    public ResponseEntity<DetallesCliente> crearDetallesCliente(@RequestBody DetallesCliente detallesCliente) {
        DetallesCliente nuevosDetallesCliente = detallesClienteService.crearDetallesCliente(detallesCliente);
        return new ResponseEntity<>(nuevosDetallesCliente, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los detalles de los clientes
    @GetMapping("detalles-cliente")
    public ResponseEntity<List<DetallesCliente>> obtenerTodosLosDetallesClientes() {
        List<DetallesCliente> detallesClientes = detallesClienteService.obtenerTodosLosDetallesClientes();
        return new ResponseEntity<>(detallesClientes, HttpStatus.OK);
    }

    // Endpoint para obtener detalles de cliente por ID
    @GetMapping("detalles-cliente/{id}")
    public ResponseEntity<DetallesCliente> obtenerDetallesClientePorId(@PathVariable String id) {
        Optional<DetallesCliente> detallesCliente = detallesClienteService.obtenerDetallesClientePorId(id);
        return detallesCliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }

    // Endpoint para actualizar detalles de cliente por ID
    @PutMapping("detalles-cliente/{id}")
    public ResponseEntity<DetallesCliente> actualizarDetallesCliente(@PathVariable String id, @RequestBody DetallesCliente nuevosDetallesCliente) {
        DetallesCliente detallesClienteActualizado = detallesClienteService.actualizarDetallesCliente(id, nuevosDetallesCliente);
        return detallesClienteActualizado != null
                ? new ResponseEntity<>(detallesClienteActualizado, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para eliminar detalles de cliente por ID
    @DeleteMapping("detalles-cliente/{id}")
    public ResponseEntity<Void> eliminarDetallesCliente(@PathVariable String id) {
        detallesClienteService.eliminarDetallesCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //------- Ordenes de Productos -------

    @Autowired
    private OrdenServiceImpl ordenService;
    @Autowired
    private DetalleOrdenServiceImpl detalleOrdenService;
    @Autowired
    private ProductoServiceImpl productoService;

    @PostMapping("ordenes")
    public ResponseEntity<OrdenCompleta> crearOrden(@RequestBody OrdenCompleta ordenCompleta) {

        // Instancia de una nueva Orden

        Orden nuevaOrden = new Orden();
        nuevaOrden.setNumeroOrden(ordenCompleta.getNumeroOrden());
        System.out.println("**************************"+clienteService.obtenerClientePorId(ordenCompleta.getCodigoCliente()));
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(ordenCompleta.getCodigoCliente());
        if (cliente.isPresent())
            nuevaOrden.setCliente(cliente.get());
        nuevaOrden.setFechaOrden(ordenCompleta.getFechaOrden());
        nuevaOrden.setFechaEnvio(ordenCompleta.getFechaEnvio());
        nuevaOrden.setFechaPago(ordenCompleta.getFechaPago());

        Orden ordenCreada = ordenService.crearOrden(nuevaOrden);

        // Instancia del detalle de la nueva orden

        

        return new ResponseEntity<>(ordenCompleta, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los clientes
    @GetMapping("ordenes")
    public ResponseEntity<List<Orden>> obtenerTodasLasOrdenes() {
        List<Orden> ordenes = ordenService.obtenerTodasLasOrdenes();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    // Endpoint para obtener un cliente por ID
    @GetMapping("ordenes/{id}")
    public ResponseEntity<Orden> obtenerOrdenPorId(@PathVariable Long id) {
        Optional<Orden> orden = ordenService.obtenerOrdenPorId(id);
        return orden.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("clientes/{codigoCliente}/ordenes")
    public ResponseEntity<List<Orden>> obtenerOrdenesPorCliente(@PathVariable Long codigoCliente) {
        List<Orden> ordenes = ordenService.obtenerOrdenesPorCliente(codigoCliente);
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    // Endpoint para actualizar un cliente por ID
    @PutMapping("ordenes/{id}")
    public ResponseEntity<Orden> actualizarOrden(@PathVariable Long id, @RequestBody OrdenCompleta ordenCompleta) {
        Orden nuevaOrden = new Orden();
        nuevaOrden.setNumeroOrden(ordenCompleta.getNumeroOrden());
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(ordenCompleta.getCodigoCliente());
        cliente.ifPresent(nuevaOrden::setCliente);

        nuevaOrden.setFechaOrden(ordenCompleta.getFechaOrden());
        nuevaOrden.setFechaEnvio(ordenCompleta.getFechaEnvio());
        nuevaOrden.setFechaPago(ordenCompleta.getFechaPago());

        Orden ordenActualizada = ordenService.actualizarOrden(id, nuevaOrden);
        return ordenActualizada != null
                ? new ResponseEntity<>(ordenActualizada, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para eliminar un cliente por ID
    @DeleteMapping("ordenes/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //------- Ordenes de DetalleDeProducto -------

    @PostMapping("ordenes-detalle")
    public ResponseEntity<DetalleOrden> crearDetalleOrden(@RequestBody DetalleOrdenCompleto detalleOrden) {

        // Instancia del detalle de la nueva orden

        DetalleOrdenId detalleOrdenId = new DetalleOrdenId(detalleOrden.getNumeroOrden(), detalleOrden.getProductId());
        DetalleOrden nuevoDetalleOrden = new DetalleOrden();
        nuevoDetalleOrden.setId(detalleOrdenId);
        Optional<Producto> producto = productoService.obtenerProductoPorId(detalleOrden.getProductId());
        if (producto.isPresent()){
            Producto productoExistente = producto.get();
            nuevoDetalleOrden.setProducto(productoExistente);
            Long nuevaCantidad = productoExistente.getCantidadDisponible() - detalleOrden.getCantidad();
            productoExistente.setCantidadDisponible(nuevaCantidad);
            productoService.actualizarProducto(detalleOrden.getProductId(), productoExistente); //Restar la cantidad en Stock
        }
        Optional<Orden> orden = ordenService.obtenerOrdenPorId(detalleOrden.getNumeroOrden());
        orden.ifPresent(nuevoDetalleOrden::setOrden);
        nuevoDetalleOrden.setCantidad(detalleOrden.getCantidad());
        nuevoDetalleOrden.setPrecio(detalleOrden.getPrecio());

        DetalleOrden detalleOrdenCreado = detalleOrdenService.crearDetalleOrden(nuevoDetalleOrden);
        
        if(detalleOrdenCreado != null){
            System.out.println("lo logramos");
        }else{
            System.out.println("no lo logramos");
        }

        return new ResponseEntity<>(detalleOrdenCreado, HttpStatus.CREATED);
    }

    @GetMapping("ordenes-detalle/{numeroOrden}")
    public ResponseEntity<List<DetalleOrden>> obtenerDetallesPorNumeroOrden(@PathVariable Long numeroOrden) {
        List<DetalleOrden> detalles = detalleOrdenService.obtenerDetallesPorNumeroOrden(numeroOrden);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    //------- productos -------
    @Autowired
    private ProductoServiceImpl productService;

    // Endpoint para obtener todos los clientes
    @GetMapping("products")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productService.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //------- CATEGORIAS -------
    @Autowired
    private CategoryServiceImpl categoryService;

    // Endpoint para obtener todos los clientes
    @GetMapping("categories")
    public ResponseEntity<List<Categoria>> obtenerTodosLasCategorias() {
        List<Categoria> categorias = categoryService.obtenerTodosLasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}