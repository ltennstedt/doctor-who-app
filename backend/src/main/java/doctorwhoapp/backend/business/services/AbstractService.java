package doctorwhoapp.backend.business.services;

import doctorwhoapp.backend.business.mappers.BusinessMapper;
import doctorwhoapp.backend.data.entities.AbstractEntity;
import doctorwhoapp.backend.domain.AbstractModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

abstract class AbstractService<
        R extends JpaRepository<E, Integer>,
        BM extends BusinessMapper<E, M>,
        E extends AbstractEntity,
        M extends AbstractModel> {
    private final R repository;
    private final BM businessMapper;

    AbstractService(final R repository, final BM businessMapper) {
        this.repository = repository;
        this.businessMapper = businessMapper;
    }

    public Optional<M> findById(final int id) {
        return repository.findById(id).map(businessMapper::mapFromEntityToModel);
    }

    public List<M> findAll() {
        return repository.findAll().stream()
                .map(businessMapper::mapFromEntityToModel)
                .toList();
    }

    public M save(final @NotNull @Valid M model) {
        return businessMapper.mapFromEntityToModel(repository.save(businessMapper.mapFromModelToEntity(model)));
    }

    public void deleteById(final int id) {
        repository.deleteById(id);
    }
}
