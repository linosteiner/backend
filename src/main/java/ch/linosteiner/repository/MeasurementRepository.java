package ch.linosteiner.repository;

import ch.linosteiner.domain.Measurement;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
