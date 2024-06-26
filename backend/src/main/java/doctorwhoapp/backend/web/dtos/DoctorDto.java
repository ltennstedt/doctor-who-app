package doctorwhoapp.backend.web.dtos;

import doctorwhoapp.backend.enums.Gender;
import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public final class DoctorDto extends PersonDto {
    private static final String NAME = "The Doctor";
    private final @Positive int incarnationNumber;
    private final @NotBlank String incarnationName;
    private final String slogan;
    private final Integer predecessorId;
    private final Integer successorId;

    public DoctorDto(
            final Integer id,
            final int incarnationNumber,
            final String incarnationName,
            final Gender gender,
            final String slogan,
            final String englishWikipediaUrl,
            final String germanWikipediaUrl,
            final Integer predecessorId,
            final Integer successorId) {
        super(id, gender, englishWikipediaUrl, germanWikipediaUrl);
        this.incarnationNumber = incarnationNumber;
        this.incarnationName = incarnationName;
        this.slogan = slogan;
        this.predecessorId = predecessorId;
        this.successorId = successorId;
    }

    public String getName() {
        return NAME;
    }

    public Species getSpecies() {
        return Species.GALLIFREYAN;
    }

    public Planet getHomePlanet() {
        return Planet.GALLIFREY;
    }

    public int getIncarnationNumber() {
        return incarnationNumber;
    }

    public String getIncarnationName() {
        return incarnationName;
    }

    public String getSlogan() {
        return slogan;
    }

    public Integer getPredecessorId() {
        return predecessorId;
    }

    public Integer getSuccessorId() {
        return successorId;
    }
}
