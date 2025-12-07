package ch.linosteiner.backend.service;

import ch.linosteiner.backend.model.Measurement;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MeasurementService {
    private List<Measurement> db;

    @PostConstruct
    public void init() {
        db = new ArrayList<>();
        db.add(new Measurement("01.12.2025", "Felix", 180.0, 80.0));
        db.add(new Measurement("01.12.2025", "Beate", 150.0, 50.0));
    }

    public List<Measurement> getAll() {
        return db;
    }

    public void add(Measurement m) {
        db.add(m);
    }
}
