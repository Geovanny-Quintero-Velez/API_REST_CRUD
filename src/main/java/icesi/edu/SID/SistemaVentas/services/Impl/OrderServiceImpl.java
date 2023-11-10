package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.Order;
import icesi.edu.SID.SistemaVentas.repositories.OrderRepository;
import icesi.edu.SID.SistemaVentas.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            // Actualiza los campos según sea necesario
            existingOrder.setCustomer(order.getCustomer());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setShippedDate(order.getShippedDate());
            existingOrder.setPaymentDate(order.getPaymentDate());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return orderRepository.save(existingOrder);
        }

        return null; // Manejar el caso donde no se encuentra el pedido con el ID proporcionado
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}