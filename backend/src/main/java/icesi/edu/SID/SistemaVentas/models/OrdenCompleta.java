package icesi.edu.SID.SistemaVentas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenCompleta {
    private Long numeroOrden;
    private Long codigoCliente;
    private Long codigoProducto;
    private Date fechaOrden;
    private Date fechaEnvio;
    private Date fechaPago;
    private Long cantidad;
    private Long precio;

    @Override
    public String toString() {
        return String.format(
            "OrdenCompleta [numeroOrden=%d, codigoCliente=%d, codigoProducto=%d, fechaOrden=%s, fechaEnvio=%s, fechaPago=%s, cantidad=%d, precio=%d]",
            numeroOrden, codigoCliente, codigoProducto, fechaOrden, fechaEnvio, fechaPago, cantidad, precio
        );
    }
}
