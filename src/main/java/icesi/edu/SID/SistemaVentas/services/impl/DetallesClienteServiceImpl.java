package icesi.edu.SID.SistemaVentas.services.impl;

import icesi.edu.SID.SistemaVentas.models.DetallesCliente;
import icesi.edu.SID.SistemaVentas.repositories.DetallesClienteRepository;
import icesi.edu.SID.SistemaVentas.services.DetallesClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetallesClienteServiceImpl implements DetallesClienteService {
    @Autowired
    private DetallesClienteRepository detallesClienteRepository;

    @Override
    public DetallesCliente crearDetallesCliente(DetallesCliente detallesCliente) {
        return detallesClienteRepository.save(detallesCliente);
    }

    @Override
    public List<DetallesCliente> obtenerTodosLosDetallesClientes() {
        return detallesClienteRepository.findAll();
    }

    @Override
    public Optional<DetallesCliente> obtenerDetallesClientePorId(String id) {
        return detallesClienteRepository.findById(id);
    }

    @Override
    public DetallesCliente actualizarDetallesCliente(String id, DetallesCliente nuevosDetallesCliente) {
        return detallesClienteRepository.findById(id).map(detallesCliente -> {
            detallesCliente.setResidencia(nuevosDetallesCliente.getResidencia());
            detallesCliente.setHijos(nuevosDetallesCliente.getHijos());
            return detallesClienteRepository.save(detallesCliente);
        }).orElse(null);
    }

    @Override
    public void eliminarDetallesCliente(String id) {
        detallesClienteRepository.deleteById(id);
    }
}
