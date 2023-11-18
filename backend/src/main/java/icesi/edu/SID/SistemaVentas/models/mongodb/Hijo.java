package icesi.edu.SID.SistemaVentas.models.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hijo {
    private String nombre;
    private Date fechaNacimiento;
    private String genero;
    private boolean studying;

}

