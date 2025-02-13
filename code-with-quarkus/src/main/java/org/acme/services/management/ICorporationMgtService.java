package org.acme.services.management;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Corporation;



@ApplicationScoped
public interface ICorporationMgtService {
    

    /**
     * cette fonction sert a créer un personne morale
     * @param corporation
     */
    public Corporation createCorporation(Corporation corporation);

    /**
     * 
     */
    public List<Corporation> getAllCorporations();

    /**
     * 
     */
    public Corporation getCorporationById(int id);

    /**
     * 
     */
    public Corporation updateCorporation(Integer corporationId, Corporation updatedCorporation);

    /**
     * 
     */
    public void deleteCorporation(int id);
}
