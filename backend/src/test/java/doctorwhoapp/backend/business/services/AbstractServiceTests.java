package doctorwhoapp.backend.business.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import doctorwhoapp.backend.business.mappers.DoctorBusinessMapper;
import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.data.repositories.DoctorRepository;
import doctorwhoapp.backend.domain.DoctorModel;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@ExtendWith(MockitoExtension.class)
final class AbstractServiceTests {
    @InjectMocks
    private DoctorService service;

    @Mock
    private DoctorRepository repository;

    @Mock
    private DoctorBusinessMapper businessMapper;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(repository, businessMapper);
    }

    @Test
    void findById_should_call_repository_and_businessMapper_and_return_model() {
        final var entity = new DoctorEntity();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        final var model = doctorModel();
        when(businessMapper.mapFromEntityToModel(entity)).thenReturn(model);

        final var actualModel = service.findById(1);

        assertThat(actualModel.orElseThrow()).isSameAs(model);
    }

    @Test
    void findAll_should_call_repository_and_businessMapper_and_return_models() {
        final var entity = new DoctorEntity();
        when(repository.findAll()).thenReturn(List.of(entity));
        final var model = doctorModel();
        when(businessMapper.mapFromEntityToModel(entity)).thenReturn(model);

        final var actualModels = service.findAll();

        assertThat(actualModels).containsExactly(model);
    }

    @Test
    void save_should_call_repository_and_businessMapper_and_return_model() {
        final var model = doctorModel();
        final var entity = new DoctorEntity();
        when(businessMapper.mapFromModelToEntity(model)).thenReturn(entity);
        final var savedEntity = new DoctorEntity();
        when(repository.save(entity)).thenReturn(savedEntity);
        final var savedModel = doctorModel();
        when(businessMapper.mapFromEntityToModel(savedEntity)).thenReturn(savedModel);

        final var actualModel = service.save(model);

        assertThat(actualModel).isSameAs(savedModel);
    }

    @Test
    void deleteById_should_delegate_to_repository() {
        service.deleteById(1);

        verify(repository).deleteById(1);
    }

    private DoctorModel doctorModel() {
        return new DoctorModel(null, 0, null, null, null, null, null, null, null);
    }

    @Nested
    @SpringBootTest(classes = DoctorService.class, webEnvironment = WebEnvironment.NONE)
    @Import(ValidationAutoConfiguration.class)
    final class ValidatedTests {
        @Autowired
        private DoctorService service;

        @MockBean
        private DoctorRepository repository;

        @MockBean
        private DoctorBusinessMapper businessMapper;

        @Test
        void save_should_throw_Exception_when_model_is_null() {
            assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy(() -> service.save(null));
        }

        @Test
        void save_should_throw_Exception_when_model_is_invalid() {
            final var model = new DoctorModel(null, 0, null, null, null, null, null, null, null);

            assertThatExceptionOfType(ConstraintViolationException.class).isThrownBy(() -> service.save(model));
        }
    }
}
