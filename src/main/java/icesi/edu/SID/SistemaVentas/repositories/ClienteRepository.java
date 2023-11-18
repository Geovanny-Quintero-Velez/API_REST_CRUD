package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import icesi.edu.SID.SistemaVentas.models.postgres.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados si es necesario
}
