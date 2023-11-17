package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.DetallesCliente;

import java.util.List;
import java.util.Optional;

public interface DetallesClienteService {
    public DetallesCliente crearDetallesCliente(DetallesCliente detallesCliente);

    public List<DetallesCliente> obtenerTodosLosDetallesClientes();

    public Optional<DetallesCliente> obtenerDetallesClientePorId(String id);

    public DetallesCliente actualizarDetallesCliente(String id, DetallesCliente nuevosDetallesCliente);

    public void eliminarDetallesCliente(String id);
}
