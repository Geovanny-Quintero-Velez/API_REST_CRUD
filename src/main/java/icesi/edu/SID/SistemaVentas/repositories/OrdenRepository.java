package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icesi.edu.SID.SistemaVentas.models.postgres.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    // Métodos personalizados si es necesario
}
