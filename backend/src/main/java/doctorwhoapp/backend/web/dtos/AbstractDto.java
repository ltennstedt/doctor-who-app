package doctorwhoapp.backend.web.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public abstract class AbstractDto {
    private final Integer id;
    private final @NotNull @URL String englishWikipediaUrl;
    private final @NotNull @URL String germanWikipediaUrl;

    AbstractDto(final Integer id, final String englishWikipediaUrl, final String germanWikipediaUrl) {
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
