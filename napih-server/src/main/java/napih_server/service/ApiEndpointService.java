package napih_server.service;

import org.springframework.stereotype.Service;
import napih_server.model.ApiEndpoint;
import napih_server.repository.ApiEndpointRepository;

import java.util.List;

@Service
public class ApiEndpointService {

    private final ApiEndpointRepository repo;

    public ApiEndpointService(ApiEndpointRepository repo) {
        this.repo = repo;
    }

    public ApiEndpointResponse create(RegisterApiRequest request) {
        ApiEndpoint entity = new ApiEndpoint();

        entity.setName(request.getName());
        entity.setUrl(request.getUrl());
        entity.setHttpMethod(request.getHttpMethod());
        entity.setHeaders(request.getHeaders());

        ApiEndpoint saved = repo.save(entity);

        return mapToResponse(saved);
    }

    public List<ApiEndpointResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ApiEndpointResponse getById(Long id) {
        ApiEndpoint endpoint = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Endpoint not found"));

        return mapToResponse(endpoint);
    }

    public ApiEndpointResponse update(Long id, UpdateApiRequest request) {
        ApiEndpoint endpoint = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Endpoint not found"));

        endpoint.setName(request.getName());
        endpoint.setUrl(request.getUrl());
        endpoint.setHttpMethod(request.getHttpMethod());
        endpoint.setHeaders(request.getHeaders());

        return mapToResponse(repo.save(endpoint));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private ApiEndpointResponse mapToResponse(ApiEndpoint entity) {
        ApiEndpointResponse res = new ApiEndpointResponse();
        res.setId(entity.getId());
        res.setName(entity.getName());
        res.setUrl(entity.getUrl());
        res.setHttpMethod(entity.getHttpMethod());
        res.setHeaders(entity.getHeaders());
        return res;
    }
}