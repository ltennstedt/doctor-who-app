package doctorwhoapp.backend.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity(name = "Doctor")
public class DoctorEntity extends PersonEntity {
    private int incarnationNumber;

    @Column(nullable = false)
    private String incarnationName;

    private String slogan;

    @OneToOne(fetch = FetchType.LAZY)
    private DoctorEntity predecessor;

    @OneToOne(fetch = FetchType.LAZY)
    private DoctorEntity successor;

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

    public DoctorEntity getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final DoctorEntity predecessor) {
        this.predecessor = predecessor;
    }

    public DoctorEntity getSuccessor() {
        return successor;
    }

    public void setSuccessor(final DoctorEntity successor) {
        this.successor = successor;
    }
}
