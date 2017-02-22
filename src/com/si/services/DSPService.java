package com.si.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/")
public class DSPService {
    public DSPService() {
    }

    @GET
    @Path("/helloDSP/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHelloDSP(final @PathParam("name") String name) {
        return Response.ok("Hello " + name + ", let's have some fun.").build();
    }
}
