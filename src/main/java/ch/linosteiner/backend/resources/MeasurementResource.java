package ch.linosteiner.backend.resources;

import ch.linosteiner.backend.model.Measurement;
import ch.linosteiner.backend.service.MeasurementService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/measurements")
public class MeasurementResource {
    private final MeasurementService service;

    @Inject
    public MeasurementResource(MeasurementService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMeasurements() {
        return Response.ok(service.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMeasurement(Measurement measurement) {
        if (measurement.getHeight() <= 0 || measurement.getWeight() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
        service.add(measurement);
        return Response.status(Response.Status.CREATED).entity("New resource created").build();
    }
}
