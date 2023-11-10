package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderNumber")
    @JoinColumn(name = "OrderNumber")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

}

