package icesi.edu.SID.SistemaVentas.models.postgres;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fechaNacimiento;
    private String correo;
    private String celular;

    public String toString(){
        return "name: " + nombre + "\n apellido: " + apellido;
    }
}