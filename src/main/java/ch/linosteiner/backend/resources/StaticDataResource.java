package ch.linosteiner.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;

@Path("/")
public class StaticDataResource {

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {
        InputStream categories = loadResourceAsStream("categories.json");
        if (categories == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(categories).build();
    }

    @GET
    @Path("/statistics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatistics() {
        InputStream statistics = loadResourceAsStream("statistics.json");
        if (statistics == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(statistics).build();
    }

    @POST
    @Path("/categories")
    public Response postCat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @PUT
    @Path("/categories")
    public Response putCat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @DELETE
    @Path("/categories")
    public Response delCat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @POST
    @Path("/statistics")
    public Response postStat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @PUT
    @Path("/statistics")
    public Response putStat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    @DELETE
    @Path("/statistics")
    public Response delStat() {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    private InputStream loadResourceAsStream(String name) {
        return this.getClass().getClassLoader().getResourceAsStream(name);
    }

}
