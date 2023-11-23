package icesi.edu.SID.SistemaVentas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleOrdenCompleto {
    
    private Long numeroOrden;
    private Long productId;
    private Long cantidad;
    private Long precio;
    
}
