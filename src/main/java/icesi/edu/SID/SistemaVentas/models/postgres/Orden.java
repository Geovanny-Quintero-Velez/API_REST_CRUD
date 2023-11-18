package icesi.edu.SID.SistemaVentas.models.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    private Long numeroOrden;
    
    @ManyToOne
    @JoinColumn(name = "codigoCliente", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;
    
    private Date fechaOrden;
    private Date fechaEnvio;
    private Date fechaPago;
    
    @Override
    public String toString(){
        return "cliente: " + cliente.toString() + "\n " + "fecha-orden: " + fechaOrden + "\n " + "fecha-envio: " + fechaEnvio + "\n " + "fecha-pago: " + fechaPago + "\n ";
    }

}
