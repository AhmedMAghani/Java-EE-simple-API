package com.Home.TaskRest.Boundry;

import com.Home.TaskRest.Entity.Region;
import com.Home.TaskRest.Service.DBService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.LinkedList;

@Path("RegionTask")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegionRest {
    @Inject
    private DBService dbService;

    @Path("Create")
    @POST
    public Response createRegion(Region region){
        //api/v1/RegionTask/Create
        dbService.createRegion(region);
        return Response.ok(region).build();
    }

    @Path("AllRegion")
    @GET
    public Response getAllRegion(){
        //api/v1/RegionTask/AllRegion
        LinkedList<Region> regions = dbService.findAll();
        return Response.ok(regions).build();
    }

    @Path("FindRegion")
    @GET
    public Response findRegion(@QueryParam("RegionID")BigDecimal id){
        //api/v1/RegionTask/FindRegion
        LinkedList<Region> regions = dbService.findRegion(id);
        return Response.ok(regions).build();
    }

    @Path("Update")
    @PUT
    public Response updateRegion(Region region){
        //api/v1/RegionTask/update
        dbService.updateRegion(region);
        return Response.ok(region).build();
    }
}
