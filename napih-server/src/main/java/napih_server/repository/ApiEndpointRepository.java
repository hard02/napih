package napih_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import napih_server.model.ApiEndpoint;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiEndpointRepository extends JpaRepository<ApiEndpoint, Long> {
    // custom queries come  here

    // Find by name (exact match)
    Optional<ApiEndpoint> findByName(String name);

    // Search by name (case-insensitive, partial match)
    List<ApiEndpoint> findByNameContainingIgnoreCase(String name);

    // Find by HTTP method (GET, POST, etc.)
    List<ApiEndpoint> findByHttpMethod(String httpMethod);

    // Combined filter (useful for future filtering UI)
    List<ApiEndpoint> findByNameContainingIgnoreCaseAndHttpMethod(
            String name, String httpMethod);

    // Check if endpoint already exists (avoid duplicates)
    boolean existsByName(String name);

    boolean existsByUrlAndHttpMethod(String url, String httpMethod);
}