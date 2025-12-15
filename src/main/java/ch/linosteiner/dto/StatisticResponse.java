package ch.linosteiner.dto;

import ch.linosteiner.domain.Statistic;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Serdeable
public record StatisticResponse(
        String source,
        String date,
        Map<String, Statistic> countries
) {
}
