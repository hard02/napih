package napih_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import napih_server.model.ApiEndpoint;

@Repository
public interface ApiEndpointRepository extends JpaRepository<ApiEndpoint, Long>{
    // Custom queries comes here
}
