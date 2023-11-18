package icesi.edu.SID.SistemaVentas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import icesi.edu.SID.SistemaVentas.models.mongodb.DetallesCliente;

public interface DetallesClienteRepository extends MongoRepository<DetallesCliente, String> {
    // Métodos personalizados si es necesario
}