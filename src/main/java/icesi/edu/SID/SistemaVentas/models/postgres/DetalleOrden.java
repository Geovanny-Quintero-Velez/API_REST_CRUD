package icesi.edu.SID.SistemaVentas.models.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detallesOrdenes")
public class DetalleOrden {

    @EmbeddedId
    private DetalleOrdenId id;

    @ManyToOne
    @MapsId("numeroOrden")
    @JoinColumn(name = "numeroOrden", referencedColumnName = "numeroOrden")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Orden orden;

    @ManyToOne
    @MapsId("codigoProducto")
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;


    private Long cantidad;
    private Long precio;
    
}
