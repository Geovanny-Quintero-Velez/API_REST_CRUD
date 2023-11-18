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

    @Column(name = "numeroOrden")
    private Long numeroOrden;

    @Column(name = "codigoProducto")
    private Long productId;

}