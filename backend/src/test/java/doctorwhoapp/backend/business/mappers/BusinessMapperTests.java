package doctorwhoapp.backend.business.mappers;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.domain.DoctorModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class BusinessMapperTests {
    @Spy
    private DoctorBusinessMapper businessMapper;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(businessMapper);
    }

    @Test
    void mapFromEntityToModel_should_call_overload() {
        final var entity = new DoctorEntity();

        businessMapper.mapFromEntityToModel(entity);

        verify(businessMapper).mapFromEntityToModel(entity);
        verify(businessMapper).mapFromEntityToModel(same(entity), notNull());
    }

    @Test
    void mapFromModelToEntity_should_call_overload() {
        final var model = new DoctorModel(null, 0, null, null, null, null, null, null, null);

        businessMapper.mapFromModelToEntity(model);

        verify(businessMapper).mapFromModelToEntity(model);
        verify(businessMapper).mapFromModelToEntity(same(model), notNull());
    }
}
