package doctorwhoapp.backend.web.mappers;

import doctorwhoapp.backend.business.services.DoctorService;
import doctorwhoapp.backend.domain.DoctorModel;
import doctorwhoapp.backend.web.dtos.DoctorDto;
import java.util.NoSuchElementException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DoctorWebMapper {
    private final DoctorService doctorService;

    public DoctorWebMapper(final DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public DoctorDto mapFromModelToDto(final @Nullable DoctorModel model) {
        if (model == null) {
            return null;
        }
        return new DoctorDto(
                model.getId(),
                model.getIncarnationNumber(),
                model.getIncarnationName(),
                model.getGender(),
                model.getSlogan(),
                model.getEnglishWikipediaUrl(),
                model.getGermanWikipediaUrl(),
                model.getPredecessorId(),
                model.getSuccessorId());
    }

    public DoctorModel mapFromDtoToModel(final @Nullable DoctorDto dto) {
        if (dto == null) {
            return null;
        }
        final var message = "No doctor with ID=%s found";
        final var predecessor = doctorService
                .findById(dto.getPredecessorId())
                .orElseThrow(() -> new NoSuchElementException(message.formatted(dto.getPredecessorId())));
        final var successor = doctorService
                .findById(dto.getSuccessorId())
                .orElseThrow(() -> new NoSuchElementException(message.formatted(dto.getSuccessorId())));
        return new DoctorModel(
                dto.getId(),
                dto.getIncarnationNumber(),
                dto.getIncarnationName(),
                dto.getGender(),
                dto.getSlogan(),
                dto.getEnglishWikipediaUrl(),
                dto.getGermanWikipediaUrl(),
                predecessor,
                successor);
    }
}
