package doctorwhoapp.backend.business.mappers;

import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.domain.Doctor;
import doctorwhoapp.backend.mapping.MapstructConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface DoctorBusinessMapper extends BusinessMapper<DoctorEntity, Doctor> {}
