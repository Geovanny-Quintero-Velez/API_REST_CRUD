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
    private Date fechaOrden;
    private Date fechaEnvio;
    private Date fechaPago;

    @Override
    public String toString() {
        return String.format(
            "OrdenCompleta [numeroOrden=%d, codigoCliente=%d, fechaOrden=%s, fechaEnvio=%s, fechaPago=%s]",
            numeroOrden, codigoCliente, fechaOrden, fechaEnvio, fechaPago
        );
    }
}
