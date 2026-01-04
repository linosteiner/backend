package ch.linosteiner.domain;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Serdeable
@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "principal_id")
    private Principal principal;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
