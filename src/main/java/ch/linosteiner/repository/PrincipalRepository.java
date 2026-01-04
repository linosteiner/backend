package ch.linosteiner.repository;

import ch.linosteiner.domain.Principal;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface PrincipalRepository extends CrudRepository<Principal, Long> {
    Optional<Principal> findByUsername(String username);
}
