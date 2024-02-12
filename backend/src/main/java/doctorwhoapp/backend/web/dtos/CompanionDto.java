package doctorwhoapp.backend.web.dtos;

import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CompanionDto extends PersonDto {
    private @NotNull Species species;
    private @NotNull Planet homePlanet;
    private @NotEmpty List<@NotNull Integer> doctorIds;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(final Species species) {
        this.species = species;
    }

    public Planet getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(final Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

    public List<Integer> getDoctorIds() {
        return doctorIds;
    }

    public void setDoctorIds(final List<Integer> doctorIds) {
        this.doctorIds = doctorIds;
    }
}
