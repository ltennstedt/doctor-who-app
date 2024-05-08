package doctorwhoapp.backend.web.mappers;

import doctorwhoapp.backend.domain.CompanionModel;
import doctorwhoapp.backend.mapping.MapstructBidirectionalMappingContext;
import doctorwhoapp.backend.mapping.MapstructConfiguration;
import doctorwhoapp.backend.web.dtos.CompanionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class)
public interface CompanionWebMapper extends WebMapper<CompanionModel, CompanionDto> {
    @Override
    @Mapping(target = "doctorIds", ignore = true)
    CompanionDto mapFromModelToDto(CompanionModel model, MapstructBidirectionalMappingContext context);

    @Override
    @Mapping(target = "doctors", ignore = true)
    CompanionModel mapFromDtoToModel(CompanionDto model, MapstructBidirectionalMappingContext context);
}
