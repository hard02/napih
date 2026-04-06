package napih_server.dto.request;

import lombok.Data;

@Data
public class RegisterApiRequest {
    private String name;
    private String url;
    private String httpMethod;
    private String headers;

}
