package doctorwhoapp.backend.web.dtos;

import doctorwhoapp.backend.enums.Gender;
import jakarta.validation.constraints.NotNull;

public class PersonDto extends AbstractDto {
    private @NotNull Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }
}
