package ch.linosteiner.controller;

import ch.linosteiner.domain.Category;
import ch.linosteiner.domain.Measurement;
import ch.linosteiner.domain.Statistic;
import ch.linosteiner.dto.StatisticDTO;
import ch.linosteiner.repository.CategoryRepository;
import ch.linosteiner.repository.MeasurementRepository;
import ch.linosteiner.repository.PrincipalRepository;
import ch.linosteiner.repository.StatisticRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller("/rest")
@Secured(SecurityRule.IS_ANONYMOUS)
public class FitAppController {

    private final CategoryRepository categoryRepository;
    private final MeasurementRepository measurementRepository;
    private final PrincipalRepository principalRepository;
    private final StatisticRepository statisticRepository;

    public FitAppController(
            CategoryRepository categoryRepository,
            StatisticRepository statisticRepository,
            PrincipalRepository principalRepository,
            MeasurementRepository measurementRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.statisticRepository = statisticRepository;
        this.principalRepository = principalRepository;
        this.measurementRepository = measurementRepository;
    }

    @Get("/categories")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Get("/statistics")
    public StatisticDTO getStatistics() {
        Iterable<Statistic> allStats = statisticRepository.findAll();
        Map<String, Statistic> countriesMap = new HashMap<>();

        for (Statistic s : allStats) {
            countriesMap.put(s.getIsoCode(), s);
        }

        return new StatisticDTO(
                "https://en.wikipedia.org/wiki/List_of_countries_by_body_mass_index",
                LocalDate.now().toString(),
                countriesMap
        );
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/measurements")
    public Iterable<Measurement> getMeasurements(java.security.Principal principal) {
        return principalRepository.findByUsername(principal.getName())
                .map(user -> measurementRepository
                        .findAll()
                        .stream()
                        .filter(measurement -> measurement.getPrincipal() != null
                                && measurement.getPrincipal().getId().equals(user.getId()))
                        .toList())
                .orElse(Collections.emptyList());
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Post("/measurements")
    public HttpResponse<Measurement> addMeasurement(@Body Measurement measurement, java.security.Principal principal) {
        return principalRepository.findByUsername(principal.getName())
                .map(user -> {
                    measurement.setPrincipal(user);
                    Measurement saved = measurementRepository.save(measurement);
                    return HttpResponse.created(saved);
                })
                .orElse(HttpResponse.unauthorized());
    }
}
