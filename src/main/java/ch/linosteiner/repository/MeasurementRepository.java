package ch.linosteiner.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ch.linosteiner.domain.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
