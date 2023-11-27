package icesi.edu.SID.SistemaVentas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import icesi.edu.SID.SistemaVentas.models.postgres.Orden;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    // Métodos personalizados si es necesario
    @Query("SELECT o FROM Orden o WHERE o.cliente.id = :codigoCliente")
    List<Orden> findByCodigoCliente(@Param("codigoCliente") Long codigoCliente);

}
