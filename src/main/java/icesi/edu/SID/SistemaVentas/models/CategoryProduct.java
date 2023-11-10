package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Long code;

    @Column(name = "Description")
    private String description;

}