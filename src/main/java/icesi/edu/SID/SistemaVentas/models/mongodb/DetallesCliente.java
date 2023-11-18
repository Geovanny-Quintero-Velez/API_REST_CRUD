package icesi.edu.SID.SistemaVentas.models.mongodb;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "detallesClientes")
public class DetallesCliente {
    @Id
    private String id;

    private List<Hijo> hijos;
    private Lugar residencia;
    private List<String> pasatiempos;
    private List<Long> categoriasDeInteres;
}

