package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public final class DoctorModel extends PersonModel {
    private final @Positive int incarnationNumber;
    private final @NotBlank String incarnationName;
    private final String slogan;
    private final DoctorModel predecessor;
    private final DoctorModel successor;

    public DoctorModel(
            final Integer id,
            final int incarnationNumber,
            final String incarnationName,
            final Gender gender,
            final String slogan,
            final String englishWikipediaUrl,
            final String germanWikipediaUrl,
            final DoctorModel predecessor,
            final DoctorModel successor) {
        super(id, gender, englishWikipediaUrl, germanWikipediaUrl);
        this.incarnationNumber = incarnationNumber;
        this.incarnationName = incarnationName;
        this.slogan = slogan;
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public Integer getPredecessorId() {
        return predecessor.getId();
    }

    public Integer getSuccessorId() {
        return successor.getId();
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

    public DoctorModel getPredecessor() {
        return predecessor;
    }

    public DoctorModel getSuccessor() {
        return successor;
    }
}
