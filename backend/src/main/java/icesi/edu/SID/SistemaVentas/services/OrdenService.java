package icesi.edu.SID.SistemaVentas.services;

import java.util.List;
import java.util.Optional;

import icesi.edu.SID.SistemaVentas.models.postgres.Orden;

public interface OrdenService {
    public Orden crearOrden(Orden orden);

    public List<Orden> obtenerTodasLasOrdenes();

    public Optional<Orden> obtenerOrdenPorId(Long id);

    public List<Orden> obtenerOrdenesPorCliente(Long codigoCliente);

    public Orden actualizarOrden(Long id, Orden nuevaOrden);

    public void eliminarOrden(Long id);
}
