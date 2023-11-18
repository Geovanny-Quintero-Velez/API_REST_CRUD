package icesi.edu.SID.SistemaVentas.services;

import java.util.*;

import icesi.edu.SID.SistemaVentas.models.postgres.Cliente;

public interface ClienteService {
    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerTodosLosClientes();

    public Optional<Cliente> obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Long id, Cliente nuevoCliente);

    public void eliminarCliente(Long id);
}
