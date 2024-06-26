package doctorwhoapp.backend.web.dtos;

import com.google.common.collect.ImmutableList;
import doctorwhoapp.backend.enums.Gender;
import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public final class CompanionDto extends PersonDto {
    private final @NotNull Species species;
    private final @NotNull Planet homePlanet;
    private final @NotEmpty List<@NotNull Integer> doctorIds;

    public CompanionDto(
            final Integer id,
            final Species species,
            final Planet homePlanet,
            final Gender gender,
            final String englishWikipediaUrl,
            final String germanWikipediaUrl,
            final List<@NotNull Integer> doctorIds) {
        super(id, gender, englishWikipediaUrl, germanWikipediaUrl);
        this.species = species;
        this.homePlanet = homePlanet;
        this.doctorIds = ImmutableList.copyOf(doctorIds);
    }

    public Species getSpecies() {
        return species;
    }

    public Planet getHomePlanet() {
        return homePlanet;
    }

    public List<Integer> getDoctorIds() {
        return doctorIds;
    }
}
