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
@Table(name = "productos")
public class Producto {
    @Id
    private Long codigoProducto;

    @ManyToOne
    @JoinColumn(name = "codigoCategoria", referencedColumnName = "codigo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categoria categoria;

    private String descripcion;
    private Long cantidadDisponible;
    private Double costo;
    private Double precioVenta;

}