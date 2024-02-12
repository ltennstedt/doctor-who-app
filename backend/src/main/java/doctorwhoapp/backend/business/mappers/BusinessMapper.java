package doctorwhoapp.backend.business.mappers;

import doctorwhoapp.backend.data.entities.AbstractEntity;
import doctorwhoapp.backend.domain.AbstractModel;
import doctorwhoapp.backend.mapping.Default;
import doctorwhoapp.backend.mapping.MapstructBidirectionalMappingContext;
import org.mapstruct.Context;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.springframework.lang.Nullable;

@MapperConfig
public interface BusinessMapper<E extends AbstractEntity, M extends AbstractModel> {
    default M mapFromEntityToModel(final @Nullable E entity) {
        return mapFromEntityToModel(entity, new MapstructBidirectionalMappingContext());
    }

    @Default
    M mapFromEntityToModel(@Nullable E entity, @Context MapstructBidirectionalMappingContext context);

    default E mapFromModelToEntity(final @Nullable M model) {
        return mapFromModelToEntity(model, new MapstructBidirectionalMappingContext());
    }

    @Default
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "version", ignore = true)
    E mapFromModelToEntity(@Nullable M model, @Context MapstructBidirectionalMappingContext context);
}
