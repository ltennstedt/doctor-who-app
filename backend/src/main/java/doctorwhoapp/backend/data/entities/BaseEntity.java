package doctorwhoapp.backend.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String englishWikipediaUrl;

    @Column(nullable = false)
    private String germanWikipediaUrl;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdOn;

    @Column(nullable = false)
    @UpdateTimestamp
    private Instant updatedOn;

    @Version
    private int version;

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

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(final Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(final Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }
}
