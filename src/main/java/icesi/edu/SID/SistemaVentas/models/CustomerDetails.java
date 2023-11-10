package icesi.edu.SID.SistemaVentas.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@Data
@Document(collection = "customer_details")
public class CustomerDetails {
    @Id
    private String id;

    private List<Child> children;
    private Birthplace birthplace;
    private Location location;
    private List<String> hobbies;
    private List<String> sports;
    private MaritalStatus maritalStatus;
    private List<String> productCategoriesOfInterest;

}

@Data
class Child {
    private String name;
    private Date birthDate;
    private String gender;
    private boolean studying;
    private boolean playingVideoGames;
    private List<String> videoGamePlatforms;

}

@Data
class Birthplace {
    private String city;
    private String state;
    private String country;

}

@Data
class Location {
    private String city;
    private String state;
    private String country;
    private String postalCode;

}

enum MaritalStatus {
    SINGLE, MARRIED, DIVORCED, WIDOWED;

}
