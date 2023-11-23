package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icesi.edu.SID.SistemaVentas.models.postgres.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Métodos personalizados si es necesario
}
