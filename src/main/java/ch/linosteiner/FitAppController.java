package ch.linosteiner;

import ch.linosteiner.domain.Category;
import ch.linosteiner.domain.Measurement;
import ch.linosteiner.domain.Statistic;
import ch.linosteiner.dto.StatisticResponse;
import ch.linosteiner.repository.CategoryRepository;
import ch.linosteiner.repository.MeasurementRepository;
import ch.linosteiner.repository.StatisticRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller("/rest")
@Secured(SecurityRule.IS_ANONYMOUS) // Allow all anonymous access for now
public class FitAppController {

    private final CategoryRepository categoryRepository;
    private final StatisticRepository statisticRepository;
    private final MeasurementRepository measurementRepository;

    public FitAppController(
            CategoryRepository categoryRepository,
            StatisticRepository statisticRepository,
            MeasurementRepository measurementRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.statisticRepository = statisticRepository;
        this.measurementRepository = measurementRepository;
    }

    @Get("/categories")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Get("/statistics")
    public StatisticResponse getStatistics() {
        Iterable<Statistic> allStats = statisticRepository.findAll();
        Map<String, Statistic> countriesMap = new HashMap<>();

        for (Statistic s : allStats) {
            countriesMap.put(s.getIsoCode(), s);
        }

        return new StatisticResponse(
                "https://en.wikipedia.org/wiki/List_of_countries_by_body_mass_index",
                LocalDate.now().toString(),
                countriesMap
        );
    }

    @Get("/measurements")
    public Iterable<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    @Post("/measurements")
    public HttpResponse<Measurement> addMeasurement(@Body Measurement measurement) {
        Measurement saved = measurementRepository.save(measurement);
        return HttpResponse.created(saved);
    }
}
