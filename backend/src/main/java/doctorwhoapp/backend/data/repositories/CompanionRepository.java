package doctorwhoapp.backend.data.repositories;

import doctorwhoapp.backend.data.entities.CompanionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanionRepository extends JpaRepository<CompanionEntity, Integer> {}
