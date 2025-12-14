package ch.linosteiner.repository;

import ch.linosteiner.domain.Statistic;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, String> {
}
