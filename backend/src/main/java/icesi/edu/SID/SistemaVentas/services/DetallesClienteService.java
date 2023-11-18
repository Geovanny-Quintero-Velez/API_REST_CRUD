package icesi.edu.SID.SistemaVentas.services;

import java.util.List;
import java.util.Optional;

import icesi.edu.SID.SistemaVentas.models.mongodb.DetallesCliente;

public interface DetallesClienteService {
    public DetallesCliente crearDetallesCliente(DetallesCliente detallesCliente);

    public List<DetallesCliente> obtenerTodosLosDetallesClientes();

    public Optional<DetallesCliente> obtenerDetallesClientePorId(String id);

    public DetallesCliente actualizarDetallesCliente(String id, DetallesCliente nuevosDetallesCliente);

    public void eliminarDetallesCliente(String id);
}
