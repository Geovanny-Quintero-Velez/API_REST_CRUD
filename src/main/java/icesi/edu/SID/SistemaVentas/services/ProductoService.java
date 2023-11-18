package icesi.edu.SID.SistemaVentas.services;

import java.util.*;

import icesi.edu.SID.SistemaVentas.models.postgres.Producto;

public interface ProductoService {
    public Producto crearProducto(Producto producto);

    public List<Producto> obtenerTodosLosProductos();

    public Optional<Producto> obtenerProductoPorId(Long id);

    public Producto actualizarProducto(Long id, Producto nuevoProducto);

    public void eliminarProducto(Long id);
}