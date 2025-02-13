package org.acme.resource.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Corporation;
import org.acme.services.management.ICorporationMgtService;

import java.util.List;

@Path("/corporation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationRessource {

    @Inject
    ICorporationMgtService corporationMgtService;

    @POST
    @Path("/createCorporation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Corporation createCorporation(Corporation corporation) {
        return corporationMgtService.createCorporation(corporation);
    }

    @GET
    @Path("/getAllCorporation")
    public List<Corporation> getAllCorporation() {
        return corporationMgtService.getAllCorporations();
    }

    @GET
    @Path("/getCorporationById/{id}")
    public Corporation getCorporationById(@PathParam("id") int id) {
        Corporation corporation = corporationMgtService.getCorporationById(id);
        System.out.println(corporation);
        return corporation;
    }

    @PUT
    @Path("/updateCorporation/{id}")
    public Corporation updateCorporation(@PathParam("id") int id, Corporation updatedCorporation) {
        return corporationMgtService.updateCorporation(id, updatedCorporation);
    }

    @DELETE
    @Path("/deleteCorporation/{id}")
    public void deleteCorporation(@PathParam("id") int id) {
        corporationMgtService.deleteCorporation(id);
    }
}