package icesi.edu.SID.SistemaVentas.models.mongodb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lugar {
    private String ciudad;
    private String estado;
    private String pais;

}
