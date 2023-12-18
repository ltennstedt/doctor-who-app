package doctorwhoapp.backend.data.repositories;

import doctorwhoapp.backend.data.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {}
