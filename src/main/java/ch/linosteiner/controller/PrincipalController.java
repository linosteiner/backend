package ch.linosteiner.controller;

import ch.linosteiner.auth.PasswordHasher;
import ch.linosteiner.domain.Principal;
import ch.linosteiner.dto.UserRegistrationDTO;
import ch.linosteiner.repository.PrincipalRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.validation.Valid;

@Controller("/rest/users")
@Secured(SecurityRule.IS_ANONYMOUS)
public class PrincipalController {

    private final PrincipalRepository principalRepository;
    private final PasswordHasher passwordHasher;

    public PrincipalController(
            PrincipalRepository principalRepository,
            PasswordHasher passwordHasher
    ) {
        this.principalRepository = principalRepository;
        this.passwordHasher = passwordHasher;
    }

    @Post
    public HttpResponse<Principal> register(@Body @Valid UserRegistrationDTO dto) {
        if (principalRepository.findByUsername(dto.username()).isPresent()) {
            return HttpResponse.badRequest();
        }

        Principal principal = new Principal();
        principal.setUsername(dto.username());
        principal.setFirstName(dto.firstName());
        principal.setLastName(dto.lastName());

        principal.setPassword(passwordHasher.encode(dto.password()));

        Principal saved = principalRepository.save(principal);
        return HttpResponse.created(saved);
    }
}
