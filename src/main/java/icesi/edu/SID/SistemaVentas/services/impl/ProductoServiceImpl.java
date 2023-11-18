package icesi.edu.SID.SistemaVentas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.SID.SistemaVentas.models.postgres.Producto;
import icesi.edu.SID.SistemaVentas.repositories.ProductoRepository;
import icesi.edu.SID.SistemaVentas.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        return productoRepository.findById(id).map(orden -> {
            return productoRepository.save(nuevoProducto);
        }).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
    
}
