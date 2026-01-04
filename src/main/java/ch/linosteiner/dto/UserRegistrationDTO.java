package ch.linosteiner.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Serdeable
@Introspected
public record UserRegistrationDTO(
        @NotBlank
        String username,

        @NotBlank
        @Length(min = 8, max = 64, message = "Password must be between 8 and 64 characters long.")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).*$", message = "Password must contain at least one letter, one number, and one special character.")
        String password,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName
) {
}
