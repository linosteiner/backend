package ch.linosteiner.domain;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Serdeable
@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"user\"", nullable = false)
    private String user;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
}
