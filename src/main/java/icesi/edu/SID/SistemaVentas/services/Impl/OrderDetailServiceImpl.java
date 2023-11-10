package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.OrderDetail;
import icesi.edu.SID.SistemaVentas.models.OrderDetailId;
import icesi.edu.SID.SistemaVentas.repositories.OrderDetailRepository;
import icesi.edu.SID.SistemaVentas.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(OrderDetailId id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        return optionalOrderDetail.orElse(null);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return (OrderDetail) orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetailId id, OrderDetail orderDetail) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);

        if (optionalOrderDetail.isPresent()) {
            OrderDetail existingOrderDetail = optionalOrderDetail.get();
            // Actualiza los campos según sea necesario
            existingOrderDetail.setQuantity(orderDetail.getQuantity());
            existingOrderDetail.setPrice(orderDetail.getPrice());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return (OrderDetail) orderDetailRepository.save(existingOrderDetail);
        }

        return null; // Manejar el caso donde no se encuentra el detalle del pedido con el ID proporcionado
    }

    @Override
    public void deleteOrderDetail(OrderDetailId id) {
        orderDetailRepository.deleteById(id);
    }
}