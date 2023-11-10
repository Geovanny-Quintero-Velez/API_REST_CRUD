package icesi.edu.SID.SistemaVentas.models;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Data
@Entity
public class Customer {
    @Id
    @Column(name = "CustomerId")
    private Long customerId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Email")
    private String email;

    @Column(name = "HomePhone")
    private String homePhone;

    @Column(name = "CellPhone")
    private String cellPhone;

}

