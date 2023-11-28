package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrden;
import icesi.edu.SID.SistemaVentas.models.postgres.DetalleOrdenId;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, DetalleOrdenId> {
    @Query("SELECT d FROM DetalleOrden d WHERE d.orden.numeroOrden = :numeroOrden")
    List<DetalleOrden> findByNumeroOrden(@Param("numeroOrden") Long numeroOrden);
}
