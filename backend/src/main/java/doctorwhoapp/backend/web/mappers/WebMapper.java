package doctorwhoapp.backend.web.mappers;

import doctorwhoapp.backend.domain.AbstractModel;
import doctorwhoapp.backend.mapping.Default;
import doctorwhoapp.backend.mapping.MapstructBidirectionalMappingContext;
import doctorwhoapp.backend.web.dtos.AbstractDto;
import org.mapstruct.Context;
import org.mapstruct.MapperConfig;
import org.springframework.lang.Nullable;

@MapperConfig
public interface WebMapper<M extends AbstractModel, D extends AbstractDto> {
    default D mapFromModelToDto(final @Nullable M model) {
        return mapFromModelToDto(model, new MapstructBidirectionalMappingContext());
    }

    @Default
    D mapFromModelToDto(@Nullable M model, @Context MapstructBidirectionalMappingContext context);

    default M mapFromDtoToModel(final @Nullable D dto) {
        return mapFromDtoToModel(dto, new MapstructBidirectionalMappingContext());
    }

    @Default
    M mapFromDtoToModel(@Nullable D model, @Context MapstructBidirectionalMappingContext context);
}
