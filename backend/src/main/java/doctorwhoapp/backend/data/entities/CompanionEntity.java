package doctorwhoapp.backend.data.entities;

import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.persistence.*;
import java.util.List;

@Entity(name = "Companion")
public class CompanionEntity extends PersonEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Species species;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Planet homePlanet;

    @OneToMany
    @JoinTable(
            inverseJoinColumns = @JoinColumn(name = "doctor_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"companion_id", "doctor_id"}))
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
