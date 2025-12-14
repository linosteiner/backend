package ch.linosteiner.repository;

import ch.linosteiner.domain.Category;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
