package icesi.edu.SID.SistemaVentas.repositories;


import icesi.edu.SID.SistemaVentas.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
}
