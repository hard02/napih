package napih_server.mapper;

import napih_server.dto.request.RegisterApiRequest;
import napih_server.dto.request.UpdateApiRequest;
import napih_server.model.ApiEndpoint;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiEndpointMapper {

    // Mapper instance
    ApiEndpointMapper INSTANCE = Mappers.getMapper(ApiEndpointMapper.class);

    // Map RegisterApiRequest DTO to ApiEndpoint entity
    ApiEndpoint toEntity(RegisterApiRequest request);

    // Map UpdateApiRequest DTO to ApiEndpoint entity
    ApiEndpoint toEntity(UpdateApiRequest request);

    // Map ApiEndpoint entity to RegisterApiRequest DTO (optional, if needed)
    RegisterApiRequest toRegisterRequest(ApiEndpoint entity);

    // Map ApiEndpoint entity to UpdateApiRequest DTO (optional, if needed)
    UpdateApiRequest toUpdateRequest(ApiEndpoint entity);
}