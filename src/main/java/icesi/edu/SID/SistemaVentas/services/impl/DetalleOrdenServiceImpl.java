package icesi.edu.SID.SistemaVentas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import icesi.edu.SID.SistemaVentas.repositories.DetalleOrdenRepository;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrden;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrdenId;
import icesi.edu.SID.SistemaVentas.services.DetalleOrdenService;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden crearDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public List<DetalleOrden> obtenerTodosLosDetallesDeOrdenes() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public Optional<DetalleOrden> obtenerDetalleOrdenPorId(DetalleOrdenId id) {
        return detalleOrdenRepository.findById(id);
    }

    @Override
    public DetalleOrden actualizarDetalleOrden(DetalleOrdenId id, DetalleOrden nuevaOrden) {
        return detalleOrdenRepository.findById(id).map(orden -> {
            return detalleOrdenRepository.save(nuevaOrden);
        }).orElse(null);
    }

    @Override
    public void eliminarDetalleOrden(DetalleOrdenId id) {
        detalleOrdenRepository.deleteById(id);
    }
    
}
