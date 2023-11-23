package icesi.edu.SID.SistemaVentas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import icesi.edu.SID.SistemaVentas.models.postgres.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos personalizados si es necesario
}
