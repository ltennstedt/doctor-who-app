package doctorwhoapp.backend.data.entities;

import doctorwhoapp.backend.domain.Planet;
import doctorwhoapp.backend.domain.Species;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
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
