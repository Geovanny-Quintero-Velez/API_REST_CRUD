package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @Column(name = "OrderNumber")
    private Long orderNumber;

    @ManyToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    private Customer customer;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "ShippedDate")
    private Date shippedDate;

    @Column(name = "PaymentDate")
    private Date paymentDate;

}
