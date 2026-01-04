package ch.linosteiner.dto;

import ch.linosteiner.domain.Statistic;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Serdeable
@Introspected
public record StatisticDTO(
        String source,
        String date,
        Map<String, Statistic> countries
) {
}
