package doctorwhoapp.backend.domain;

import com.google.common.collect.ImmutableList;
import doctorwhoapp.backend.enums.Gender;
import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public final class CompanionModel extends PersonModel {
    private final @NotNull Species species;
    private final @NotNull Planet homePlanet;
    private final @NotEmpty List<@NotNull @Valid DoctorModel> doctors;

    public CompanionModel(
            final Integer id,
            final Species species,
            final Planet homePlanet,
            final Gender gender,
            final String englishWikipediaUrl,
            final String germanWikipediaUrl,
            final List<DoctorModel> doctors) {
        super(id, gender, englishWikipediaUrl, germanWikipediaUrl);
        this.species = species;
        this.homePlanet = homePlanet;
        this.doctors = ImmutableList.copyOf(doctors);
    }

    public Species getSpecies() {
        return species;
    }

    public Planet getHomePlanet() {
        return homePlanet;
    }

    public List<DoctorModel> getDoctors() {
        return doctors;
    }
}
