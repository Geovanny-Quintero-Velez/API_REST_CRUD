package icesi.edu.SID.SistemaVentas.repositories;

import icesi.edu.SID.SistemaVentas.models.CustomerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDetailsRepository extends MongoRepository<CustomerDetails, String> {
    // Métodos CRUD y consultas personalizadas
}

