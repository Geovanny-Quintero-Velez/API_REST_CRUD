package icesi.edu.SID.SistemaVentas.controllers;

import icesi.edu.SID.SistemaVentas.models.mongodb.DetallesCliente;
import icesi.edu.SID.SistemaVentas.models.postgres.Cliente;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrden;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrdenId;
import icesi.edu.SID.SistemaVentas.models.postgres.Orden;
import icesi.edu.SID.SistemaVentas.models.postgres.Producto;
import icesi.edu.SID.SistemaVentas.models.OrdenCompleta;
import icesi.edu.SID.SistemaVentas.services.impl.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
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
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(ordenCompleta.getCodigoCliente());
        if (cliente.isPresent())
            nuevaOrden.setCliente(cliente.get());
        nuevaOrden.setFechaOrden(ordenCompleta.getFechaOrden());
        nuevaOrden.setFechaEnvio(ordenCompleta.getFechaEnvio());
        nuevaOrden.setFechaPago(ordenCompleta.getFechaPago());

        Orden ordenCreada = ordenService.crearOrden(nuevaOrden);

        // Instancia del detalle de la nueva orden

        DetalleOrdenId detalleOrdenId = new DetalleOrdenId(ordenCompleta.getNumeroOrden(), ordenCompleta.getCodigoProducto());
        DetalleOrden nuevoDetalleOrden = new DetalleOrden();
        nuevoDetalleOrden.setId(detalleOrdenId);
        Optional<Producto> producto = productoService.obtenerProductoPorId(ordenCompleta.getCodigoProducto());
        if (producto.isPresent()){
            Producto productoExistente = producto.get();
            nuevoDetalleOrden.setProducto(productoExistente);
            Long nuevaCantidad = productoExistente.getCantidadDisponible() - ordenCompleta.getCantidad();
            productoExistente.setCantidadDisponible(nuevaCantidad);
            productoService.actualizarProducto(ordenCompleta.getCodigoProducto(), productoExistente); //Restar la cantidad en Stock
        }
            
        nuevoDetalleOrden.setOrden(ordenCreada);
        nuevoDetalleOrden.setCantidad(ordenCompleta.getCantidad());
        nuevoDetalleOrden.setPrecio(ordenCompleta.getPrecio());

        DetalleOrden detalleOrdenCreado = detalleOrdenService.crearDetalleOrden(nuevoDetalleOrden);
        
        if(detalleOrdenCreado != null){
            System.out.println("lo logramos");
        }else{
            System.out.println("no lo logramos");
        }

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

    // Endpoint para actualizar un cliente por ID
    @PutMapping("ordenes/{id}")
    public ResponseEntity<Orden> actualizarOrden(@PathVariable Long id, @RequestBody OrdenCompleta ordenCompleta) {
        Orden nuevaOrden = new Orden();
        nuevaOrden.setNumeroOrden(ordenCompleta.getNumeroOrden());
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(ordenCompleta.getCodigoCliente());
        if (cliente.isPresent())
            nuevaOrden.setCliente(cliente.get());
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
}