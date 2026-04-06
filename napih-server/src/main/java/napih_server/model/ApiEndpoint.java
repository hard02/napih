package napih_server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApiEndpoint {
    
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String url;
    private String httpMethod;
    private String headers;


}
