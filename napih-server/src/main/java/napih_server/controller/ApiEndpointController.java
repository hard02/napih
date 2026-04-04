package napih_server.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import napih_server.model.ApiEndpoint;

@RequestMapping("/api")
public class  ApiEndpointController{

    @PostMapping
    public ApiRequest createApiEndpoint(@RequestBody ApiEndpoint apiEndpoint) {
        // Business logic to save create
        // call to service layer
        
        // return apiRequest; 
    }
}