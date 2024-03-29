package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class Companion extends Person {
    private @NotNull Species species;
    private @NotNull Planet homePlanet;
    private @NotEmpty List<@NotNull @Valid Doctor> doctors;

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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(final List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
