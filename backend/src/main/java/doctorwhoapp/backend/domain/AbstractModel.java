package doctorwhoapp.backend.domain;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public abstract class AbstractModel {
    private final Integer id;
    private final @NotNull @URL String englishWikipediaUrl;
    private final @NotNull @URL String germanWikipediaUrl;

    AbstractModel(final Integer id, final String englishWikipediaUrl, final String germanWikipediaUrl) {
        this.id = id;
        this.englishWikipediaUrl = englishWikipediaUrl;
        this.germanWikipediaUrl = germanWikipediaUrl;
    }

    public final Integer getId() {
        return id;
    }

    public final String getEnglishWikipediaUrl() {
        return englishWikipediaUrl;
    }

    public final String getGermanWikipediaUrl() {
        return germanWikipediaUrl;
    }
}
