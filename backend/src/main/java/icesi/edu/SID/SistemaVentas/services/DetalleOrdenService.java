package icesi.edu.SID.SistemaVentas.services;

import java.util.List;
import java.util.Optional;

import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrden;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrdenId;

public interface DetalleOrdenService {
    public DetalleOrden crearDetalleOrden(DetalleOrden detalleOrden);

    public List<DetalleOrden> obtenerTodosLosDetallesDeOrdenes();

    public Optional<DetalleOrden> obtenerDetalleOrdenPorId(DetalleOrdenId id);

    public DetalleOrden actualizarDetalleOrden(DetalleOrdenId id, DetalleOrden nuevoDetalleOrden);

    public void eliminarDetalleOrden(DetalleOrdenId id);
}
