package org.acme.services.management;

import jakarta.transaction.Transactional;
import org.acme.model.Citizens;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ICitizenMgtService {

    /**
     * Create a new citizen in the DataBase
     *
     * @param newCitizen -> The citizen we want to create
     * @return The created citizen with a valid id.
     */
    public Citizens createCitizen(Citizens newCitizen);

    /**
     * Read a citizen by an id
     * 
     * @param citizenId -> The citizen's id
     * @return The Citizen
     */
    public Citizens getCitizenById(Integer citizenId);

    @Transactional
    List<Citizens> getAllCitizens();

    /**
     * Update a citizen's information
     * 
     * @param citizenId -> The Citizen we want to update
     * @param updatedCitizens -> The updated citizen
     * @return Updated Citizen
     */
    public Citizens updateCitizen(Integer citizenId, Citizens updatedCitizens);

    /**
     * Delete a Citizen
     * 
     * @param citizenId -> The Citizen's Id
     * @return None
     */
    public void deleteCitizen(Integer citizenId);

    public Citizens authenticateCitizen(String login, String password);
    

}