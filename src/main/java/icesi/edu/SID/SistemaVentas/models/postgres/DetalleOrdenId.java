package icesi.edu.SID.SistemaVentas.models.postgres;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DetalleOrdenId implements Serializable {

    @Column(name = "numero_orden")
    private Long numeroOrden;

    @Column(name = "product_id")
    private Long productId;

}