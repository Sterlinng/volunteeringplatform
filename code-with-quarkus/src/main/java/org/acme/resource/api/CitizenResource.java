package org.acme.resource.api;
import java.util.List;
import java.util.Map;

import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Path("/citizen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenResource {

    @Inject
    ICitizenMgtService citizenMgtService;

    @POST
    @Path("/createCitizen")
    @Consumes(MediaType.APPLICATION_JSON)
    public Citizens createCitizen(Citizens citizens) {
        return citizenMgtService.createCitizen(citizens);
    }

    @GET
    @Path("/getAllCitizens")
    public List<Citizens> getAllCitizens() {
        return citizenMgtService.getAllCitizens();
    }

    @GET
    @Path("/getCitizenById/{id}")
    public Citizens getCitizenById(@PathParam("id") int id) {
        Citizens citizen = citizenMgtService.getCitizenById(id);
        System.out.println(citizen);
        return citizen;
    }

    @PUT
    @Path("/updateCitizen/{id}")
    public Citizens updateCitizen(@PathParam("id") int id, Citizens updatedCitizens) {
        return citizenMgtService.updateCitizen(id, updatedCitizens);
    }

    @DELETE
    @Path("/deleteCitizen/{id}")
    public void deleteCitizen(@PathParam("id") int id) {
        citizenMgtService.deleteCitizen(id);
    }

    @POST
    @Path("/authenticate")
    public Response authenticateUser(Citizens credentials) {
        try {
            Citizens citizen = citizenMgtService.authenticateCitizen(credentials.getLogin(), credentials.getPassword());
            if (citizen != null) {
                String token = generateToken(citizen);

                Map<String, Object> responseObj = new HashMap<>();
                responseObj.put("token", token);
                responseObj.put("id", citizen.id_citizens);

                String jsonResponse = new Gson().toJson(responseObj);

                return Response.ok().entity(jsonResponse).header("Content-Type", "application/json").build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    private String generateToken(Citizens citizen) {
    long currentTimeMillis = System.currentTimeMillis();
    
    // Générer une clé sécurisée pour HS256
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    return Jwts.builder()
            .setSubject(citizen.getLogin())
            .setIssuedAt(new Date(currentTimeMillis))
            .setExpiration(new Date(currentTimeMillis + 3600000))
            .signWith(key)
            .compact();
}
}