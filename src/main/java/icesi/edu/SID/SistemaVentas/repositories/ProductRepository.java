package icesi.edu.SID.SistemaVentas.repositories;

import icesi.edu.SID.SistemaVentas.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Métodos CRUD y consultas personalizadas
}