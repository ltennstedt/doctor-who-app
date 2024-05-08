package doctorwhoapp.backend.web.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import doctorwhoapp.backend.business.services.DoctorService;
import doctorwhoapp.backend.domain.DoctorModel;
import doctorwhoapp.backend.enums.Gender;
import doctorwhoapp.backend.web.dtos.DoctorDto;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class DoctorWebMapperTests {
    @InjectMocks
    private DoctorWebMapper doctorWebMapper;

    @Mock
    private DoctorService doctorService;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(doctorService);
    }

    @Test
    void mapFromModelToDto_should_return_null_when_model_is_null() {
        assertThat(doctorWebMapper.mapFromModelToDto(null)).isNull();
    }

    @Test
    void mapFromModelToDto_should_return_dto_when_model_is_not_null() {
        final var predecessor = new DoctorModel(9, 0, null, null, null, null, null, null, null);
        final var successor = new DoctorModel(11, 0, null, null, null, null, null, null, null);
        final var model = new DoctorModel(
                10,
                10,
                "Tenth Doctor",
                Gender.MALE,
                "Allons-y",
                "https://en.wikipedia.org/wiki/Tenth_Doctor",
                "https://de.wikipedia.org/wiki/Der_Doktor#Zehnter_Doktor",
                predecessor,
                successor);

        final var actualDto = doctorWebMapper.mapFromModelToDto(model);

        assertThat(actualDto.getId()).isSameAs(model.getId());
        assertThat(actualDto.getIncarnationNumber()).isEqualByComparingTo(10);
        assertThat(actualDto.getIncarnationName()).isSameAs(model.getIncarnationName());
        assertThat(actualDto.getGender()).isSameAs(Gender.MALE);
        assertThat(actualDto.getSlogan()).isSameAs(model.getSlogan());
        assertThat(actualDto.getEnglishWikipediaUrl()).isSameAs(model.getEnglishWikipediaUrl());
        assertThat(actualDto.getGermanWikipediaUrl()).isSameAs(model.getGermanWikipediaUrl());
        assertThat(actualDto.getPredecessorId()).isSameAs(predecessor.getId());
        assertThat(actualDto.getSuccessorId()).isSameAs(successor.getId());
    }

    @Test
    void mapFromDtoToModel_should_return_null_when_dto_is_null() {
        assertThat(doctorWebMapper.mapFromModelToDto(null)).isNull();
    }

    @Test
    void mapFromDtoToModel_should_throw_Exception_when_predecessor_is_absent() {
        final var dto = new DoctorDto(null, 0, null, null, null, null, null, 0, null);

        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> doctorWebMapper.mapFromDtoToModel(dto))
                .withMessage("No doctor with ID=0 found")
                .withNoCause();
        verify(doctorService).findById(0);
    }

    @Test
    void mapFromDtoToModel_should_throw_Exception_when_successor_is_absent() {
        when(doctorService.findById(14))
                .thenReturn(Optional.of(new DoctorModel(null, 0, null, null, null, null, null, null, null)));
        final var dto = new DoctorDto(null, 0, null, null, null, null, null, 14, 16);

        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> doctorWebMapper.mapFromDtoToModel(dto))
                .withMessage("No doctor with ID=16 found")
                .withNoCause();
        verify(doctorService).findById(14);
        verify(doctorService).findById(16);
    }

    @Test
    void mapFromDtoToModel_should_return_model_when_dto_is_not_null() {
        final var predecessor = new DoctorModel(9, 0, null, null, null, null, null, null, null);
        when(doctorService.findById(same(predecessor.getId()))).thenReturn(Optional.of(predecessor));
        final var successor = new DoctorModel(11, 0, null, null, null, null, null, null, null);
        when(doctorService.findById(same(successor.getId()))).thenReturn(Optional.of(successor));
        final var dto = new DoctorDto(
                10,
                10,
                "Tenth Doctor",
                Gender.MALE,
                "Allons-y",
                "https://en.wikipedia.org/wiki/Tenth_Doctor",
                "https://de.wikipedia.org/wiki/Der_Doktor#Zehnter_Doktor",
                predecessor.getId(),
                successor.getId());

        final var actualModel = doctorWebMapper.mapFromDtoToModel(dto);

        assertThat(actualModel.getId()).isSameAs(dto.getId());
        assertThat(actualModel.getIncarnationNumber()).isEqualByComparingTo(10);
        assertThat(actualModel.getIncarnationName()).isSameAs(dto.getIncarnationName());
        assertThat(actualModel.getGender()).isSameAs(Gender.MALE);
        assertThat(actualModel.getSlogan()).isSameAs(dto.getSlogan());
        assertThat(actualModel.getEnglishWikipediaUrl()).isSameAs(dto.getEnglishWikipediaUrl());
        assertThat(actualModel.getGermanWikipediaUrl()).isSameAs(dto.getGermanWikipediaUrl());
        assertThat(actualModel.getPredecessor()).isSameAs(predecessor);
        assertThat(actualModel.getSuccessor()).isSameAs(successor);
    }
}
