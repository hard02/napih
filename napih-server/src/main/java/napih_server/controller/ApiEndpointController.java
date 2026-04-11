package napih_server.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import napih_server.dto.request.RegisterApiRequest;
import napih_server.dto.request.UpdateApiRequest;
import napih_server.dto.response.ApiEndpointResponse;
import napih_server.service.ApiEndpointService;

@RestController
@RequestMapping("/api/endpoints")
public class ApiEndpointController {

    private final ApiEndpointService service;

    public ApiEndpointController(ApiEndpointService service) {
        this.service = service;
    }

    // CREATE (Register API)
    @PostMapping
    public ResponseEntity<ApiEndpointResponse> create(@RequestBody RegisterApiRequest request) {

        ApiEndpointResponse response = service.create(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200)); // 200 OK as you wanted
    }

    // READ ALL (Paginated later)
    @GetMapping
    public ResponseEntity<List<ApiEndpointResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ApiEndpointResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiEndpointResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateApiRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}