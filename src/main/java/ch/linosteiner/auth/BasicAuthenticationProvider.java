package ch.linosteiner.auth;

import ch.linosteiner.repository.PrincipalRepository;
import io.micronaut.core.annotation.Blocking;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
import jakarta.inject.Singleton;

@Singleton
public class BasicAuthenticationProvider<B> implements HttpRequestAuthenticationProvider<B> {

    private final PasswordHasher hasher;
    private final PrincipalRepository principalRepository;

    public BasicAuthenticationProvider(
            PasswordHasher hasher,
            PrincipalRepository principalRepository
    ) {
        this.hasher = hasher;
        this.principalRepository = principalRepository;
    }

    @Override
    @Blocking
    public @NonNull AuthenticationResponse authenticate(
            HttpRequest<B> requestContext,
            @NonNull AuthenticationRequest<String, String> authRequest
    ) {
        final String username = authRequest.getIdentity();
        final String password = authRequest.getSecret();

        return principalRepository.findByUsername(username)
                .filter(principal -> hasher.matches(password, principal.getPassword()))
                .map(principal -> AuthenticationResponse.success(principal.getUsername()))
                .orElseGet(AuthenticationFailed::new);
    }
}
