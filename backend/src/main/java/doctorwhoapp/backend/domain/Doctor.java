package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Doctor extends Person {
    private @Positive int incarnationNumber;
    private @NotBlank String incarnationName;
    private String slogan;
    private Doctor predecessor;
    private Doctor successor;

    public String getName() {
        return "The DoctorDto";
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

    public void setIncarnationNumber(final int incarnationNumber) {
        this.incarnationNumber = incarnationNumber;
    }

    public String getIncarnationName() {
        return incarnationName;
    }

    public void setIncarnationName(final String incarnationName) {
        this.incarnationName = incarnationName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(final String slogan) {
        this.slogan = slogan;
    }

    public Doctor getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final Doctor predecessor) {
        this.predecessor = predecessor;
    }

    public Doctor getSuccessor() {
        return successor;
    }

    public void setSuccessor(final Doctor successor) {
        this.successor = successor;
    }
}
