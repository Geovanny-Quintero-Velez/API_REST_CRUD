package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "OrderNumber")
    private Long orderNumber;

    @Column(name = "ProductId")
    private Long productId;

}
