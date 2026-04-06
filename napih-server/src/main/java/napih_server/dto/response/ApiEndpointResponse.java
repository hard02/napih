package napih_server.dto.response;

import lombok.Data;

@Data
public class ApiEndpointResponse {
    private Long id;
    private String name;
    private String url;
    private String httpMethod;
    private String headers;

}
