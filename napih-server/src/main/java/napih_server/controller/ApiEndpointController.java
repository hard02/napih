package napih_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import napih_server.model.ApiEndpoint;
import napih_server.service.ApiEndpointService;

import java.util.List;

@RestController
@RequestMapping("/api/endpoints")
public class ApiEndpointController {

    private final ApiEndpointService service;

    public ApiEndpointController(ApiEndpointService service) {
        this.service = service;
    }

    // CREATE (Register API)
    @PostMapping
    public ResponseEntity<ApiEndpointResponse> create(
            @RequestBody RegisterApiRequest request) {

        ApiEndpointResponse response = service.create(request);
        return ResponseEntity.ok(response); // 200 OK as you wanted
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