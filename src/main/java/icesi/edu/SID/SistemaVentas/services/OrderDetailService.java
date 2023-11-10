package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.OrderDetail;
import icesi.edu.SID.SistemaVentas.models.OrderDetailId;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(OrderDetailId id);
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetailId id, OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetailId id);
}
