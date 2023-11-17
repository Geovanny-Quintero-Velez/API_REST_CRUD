package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.Cliente;

import java.util.*;

public interface ClienteService {
    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerTodosLosClientes();

    public Optional<Cliente> obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Long id, Cliente nuevoCliente);

    public void eliminarCliente(Long id);
}
