package icesi.edu.SID.SistemaVentas.repositories;

import icesi.edu.SID.SistemaVentas.models.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository<OrderDetail> extends JpaRepository<OrderDetail, OrderDetailId> {
    // Métodos CRUD y consultas personalizadas
}