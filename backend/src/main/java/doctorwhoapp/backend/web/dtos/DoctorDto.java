package doctorwhoapp.backend.web.dtos;

import doctorwhoapp.backend.enums.Planet;
import doctorwhoapp.backend.enums.Species;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DoctorDto extends PersonDto {
    private @Positive int incarnationNumber;
    private @NotBlank String incarnationName;
    private String slogan;
    private Integer predecessor;
    private Integer successor;

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

    public Integer getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final Integer predecessor) {
        this.predecessor = predecessor;
    }

    public Integer getSuccessor() {
        return successor;
    }

    public void setSuccessor(finnalInteger successor) {
        this.successor = successor;
    }
}
