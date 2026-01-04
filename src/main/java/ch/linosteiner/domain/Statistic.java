package ch.linosteiner.domain;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Serdeable
@Entity
public class Statistic {

    @Id
    @Column(name = "iso_code")
    private String isoCode;

    private String country;

    private Integer rank;

    @Column(name = "both_gender")
    private Double bothGender;
    private Double male;
    private Double female;

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getBoth() {
        return bothGender;
    } // Mapping auf JSON Property "both"

    public void setBoth(Double bothGender) {
        this.bothGender = bothGender;
    }

    public Double getMale() {
        return male;
    }

    public void setMale(Double male) {
        this.male = male;
    }

    public Double getFemale() {
        return female;
    }

    public void setFemale(Double female) {
        this.female = female;
    }
}
