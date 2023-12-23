package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Gender;

public class Person extends AbstractModel {
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }
}
