package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "ProductId")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "category_code", referencedColumnName = "Code")
    private CategoryProduct category;

    @Column(name = "Description")
    private String description;

    @Column(name = "QuantityAvailable")
    private int quantityAvailable;

    @Column(name = "Cost")
    private double cost;

    @Column(name = "SellingPrice")
    private double sellingPrice;

}
