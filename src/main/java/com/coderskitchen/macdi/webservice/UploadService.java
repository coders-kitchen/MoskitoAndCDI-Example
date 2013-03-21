package com.coderskitchen.macdi.webservice;

import com.coderskitchen.macdi.entity.ProcessState;
import net.anotheria.moskito.integration.cdi.Count;
import net.anotheria.moskito.integration.cdi.Monitor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/upload")
@Monitor
public class UploadService {

    @PUT
    @Path("{userToken}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response uploadAndProcess(@PathParam("userToken") String userToken) {
        return null;
    }

    @GET
    @Path("{userToken}/{processId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Count
    public Response getCurrentProcessState(@PathParam("userToken") String userToken, @PathParam("processId") String processId) {
        ProcessState state = new ProcessState(userToken, processId);
        state.setRunningState();
        Response r = Response.ok(state).build();
        return r;
    }

    @GET
    @Path("/status")
    public Response uploadAvailable() {
        Response r = Response.ok(Boolean.TRUE).build();
        return r;
    }

}
