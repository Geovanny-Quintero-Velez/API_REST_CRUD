package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrden;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrdenId;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, DetalleOrdenId> {
    // Métodos personalizados si es necesario
}
