package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "detallesCliente")
public class DetallesCliente {
    @Id
    private String id;

    private List<Hijo> hijos;
    private Lugar residencia;
    private List<String> pasatiempos;
    private List<String> categoriasDeInteres;
}

