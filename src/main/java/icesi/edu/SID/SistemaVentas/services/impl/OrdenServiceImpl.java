package icesi.edu.SID.SistemaVentas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import icesi.edu.SID.SistemaVentas.repositories.OrdenRepository;
import icesi.edu.SID.SistemaVentas.models.postgres.Orden;
import icesi.edu.SID.SistemaVentas.services.OrdenService;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Orden crearOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<Orden> obtenerTodasLasOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public Optional<Orden> obtenerOrdenPorId(Long id) {
        return ordenRepository.findById(id);
    }

    @Override
    public Orden actualizarOrden(Long id, Orden nuevaOrden) {
        return ordenRepository.findById(id).map(orden -> {
            return ordenRepository.save(nuevaOrden);
        }).orElse(null);
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }
    
}
