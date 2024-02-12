package doctorwhoapp.backend.business.services;

import doctorwhoapp.backend.business.mappers.DoctorBusinessMapper;
import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.data.repositories.DoctorRepository;
import doctorwhoapp.backend.domain.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class DoctorService extends AbstractService<DoctorRepository, DoctorBusinessMapper, DoctorEntity, Doctor> {
    DoctorService(final DoctorRepository repository, final DoctorBusinessMapper businessMapper) {
        super(repository, businessMapper);
    }
}
