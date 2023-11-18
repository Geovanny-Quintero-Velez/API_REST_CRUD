package icesi.edu.SID.SistemaVentas.services.impl;

import icesi.edu.SID.SistemaVentas.models.postgres.Cliente;
import icesi.edu.SID.SistemaVentas.repositories.ClienteRepository;
import icesi.edu.SID.SistemaVentas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente nuevoCliente) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(nuevoCliente.getNombre());
            cliente.setApellido(nuevoCliente.getApellido());
            cliente.setDireccion(nuevoCliente.getDireccion());
            cliente.setFechaNacimiento(nuevoCliente.getFechaNacimiento());
            cliente.setCorreo(nuevoCliente.getCorreo());
            cliente.setCelular(nuevoCliente.getCelular());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}