package icesi.edu.SID.SistemaVentas.repositories;

import icesi.edu.SID.SistemaVentas.models.DetallesCliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetallesClienteRepository extends MongoRepository<DetallesCliente, String> {
    // Métodos personalizados si es necesario
}