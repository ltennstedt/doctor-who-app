package doctorwhoapp.backend.domain;

public class Doctor extends Person {
    private int incarnationNumber;
    private String incarnationName;
    private String slogan;
    private Doctor predecessor;
    private Doctor successor;

    public String getName() {
        return "The Doctor";
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
