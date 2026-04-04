package napih_server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ApiEndpoint {
    
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String url;
    private String httpMethod;

}
