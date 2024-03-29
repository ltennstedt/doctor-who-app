package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Gender;
import jakarta.validation.constraints.NotNull;

public class Person extends AbstractModel {
    private @NotNull Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }
}
