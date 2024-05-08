package doctorwhoapp.backend.business.services;

import doctorwhoapp.backend.business.mappers.DoctorBusinessMapper;
import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.data.repositories.DoctorRepository;
import doctorwhoapp.backend.domain.DoctorModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class DoctorService extends AbstractService<DoctorRepository, DoctorBusinessMapper, DoctorEntity, DoctorModel> {
    DoctorService(final DoctorRepository repository, final DoctorBusinessMapper businessMapper) {
        super(repository, businessMapper);
    }
}
