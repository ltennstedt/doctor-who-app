package doctorwhoapp.backend.business.mappers;

import doctorwhoapp.backend.data.entities.CompanionEntity;
import doctorwhoapp.backend.domain.Companion;
import doctorwhoapp.backend.mapping.MapstructConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class, uses = DoctorBusinessMapper.class)
public interface CompanionBusinessMapper extends BusinessMapper<CompanionEntity, Companion> {}
