package icesi.edu.SID.SistemaVentas.repositories;

import icesi.edu.SID.SistemaVentas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados si es necesario
}
