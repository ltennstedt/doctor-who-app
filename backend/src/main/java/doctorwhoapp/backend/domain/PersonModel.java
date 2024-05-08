package doctorwhoapp.backend.domain;

import doctorwhoapp.backend.enums.Gender;
import jakarta.validation.constraints.NotNull;

class PersonModel extends AbstractModel {
    private final @NotNull Gender gender;

    PersonModel(
            final Integer id, final Gender gender, final String englishWikipediaUrl, final String germanWikipediaUrl) {
        super(id, englishWikipediaUrl, germanWikipediaUrl);
        this.gender = gender;
    }

    public final Gender getGender() {
        return gender;
    }
}
