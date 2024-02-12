package doctorwhoapp.backend.web.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public abstract class AbstractDto {
    private Integer id;
    private @NotNull @URL String englishWikipediaUrl;
    private @NotNull @URL String germanWikipediaUrl;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getEnglishWikipediaUrl() {
        return englishWikipediaUrl;
    }

    public void setEnglishWikipediaUrl(final String englishWikipediaUrl) {
        this.englishWikipediaUrl = englishWikipediaUrl;
    }

    public String getGermanWikipediaUrl() {
        return germanWikipediaUrl;
    }

    public void setGermanWikipediaUrl(final String germanWikipediaUrl) {
        this.germanWikipediaUrl = germanWikipediaUrl;
    }
}
