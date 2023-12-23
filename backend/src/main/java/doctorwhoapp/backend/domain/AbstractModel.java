package doctorwhoapp.backend.domain;

public abstract class AbstractModel {
    private Integer id;
    private String englishWikipediaUrl;
    private String germanWikipediaUrl;

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
