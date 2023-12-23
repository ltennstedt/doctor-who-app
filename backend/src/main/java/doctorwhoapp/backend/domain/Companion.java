package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.data.entities.DoctorEntity;
import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import java.util.List;

public class Companion extends Person {
    private Species species;
    private Planet homePlanet;
    private List<DoctorEntity> doctors;

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

    public List<DoctorEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(final List<DoctorEntity> doctors) {
        this.doctors = doctors;
    }
}
