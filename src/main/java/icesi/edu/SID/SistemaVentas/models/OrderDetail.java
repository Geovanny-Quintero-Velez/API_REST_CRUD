package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
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

@Data
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "OrderNumber")
    private Long orderNumber;

    @Column(name = "ProductId")
    private Long productId;

}
