package doctorwhoapp.backend.web.dtos;

import doctorwhoapp.backend.enums.Gender;
import jakarta.validation.constraints.NotNull;

class PersonDto extends AbstractDto {
    private final @NotNull Gender gender;

    PersonDto(
            final Integer id, final Gender gender, final String englishWikipediaUrl, final String germanWikipediaUrl) {
        super(id, englishWikipediaUrl, germanWikipediaUrl);
        this.gender = gender;
    }

    public final Gender getGender() {
        return gender;
    }
}
