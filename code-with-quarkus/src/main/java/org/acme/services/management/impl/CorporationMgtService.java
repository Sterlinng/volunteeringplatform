package org.acme.services.management.impl;

import java.util.List;
import org.acme.model.Corporation;
import org.acme.services.management.ICorporationMgtService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CorporationMgtService implements ICorporationMgtService {
    
    
    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Corporation createCorporation(Corporation newCorporation) {

        Corporation createdCorporation = new Corporation();

        createdCorporation.name = newCorporation.name;
        createdCorporation.Siret = newCorporation.Siret;
        createdCorporation.Siren = newCorporation.Siren;
        createdCorporation.mail = newCorporation.mail;
        createdCorporation.note = newCorporation.note;
        createdCorporation.address = newCorporation.address;
        createdCorporation.phone_number = newCorporation.phone_number;
        createdCorporation.ZIP_code = newCorporation.ZIP_code;
        createdCorporation.login = newCorporation.login;
        createdCorporation.password = newCorporation.password;

        entityManager.persist(createdCorporation);
        return createdCorporation;
    }

    @Transactional
    public List<Corporation> getAllCorporations() {
        return entityManager.createQuery("SELECT c FROM Corporation c", Corporation.class).getResultList();
    }

    @Transactional
    public Corporation getCorporationById(int id) {
        return entityManager.find(Corporation.class, id);
    }

    @Transactional
    public Corporation updateCorporation(Integer corporationId, Corporation updatedCorporation) {
        Corporation existingCorporation = entityManager.find(Corporation.class, corporationId);
        if (existingCorporation != null) {
            existingCorporation.name = updatedCorporation.name;
            existingCorporation.id_corporation = updatedCorporation.id_corporation;
            existingCorporation.Siret = updatedCorporation.Siret;
            existingCorporation.Siren = updatedCorporation.Siren;
            existingCorporation.phone_number = updatedCorporation.phone_number;
            existingCorporation.note = updatedCorporation.note;
            existingCorporation.address = updatedCorporation.address;
            existingCorporation.ZIP_code = updatedCorporation.ZIP_code;
        }
        return updatedCorporation;
    }

    @Transactional
    public void deleteCorporation(int id) {
        Corporation corpToDelete = entityManager.find(Corporation.class, id);
        if (corpToDelete != null) {
            entityManager.remove(corpToDelete);
        }
    }
}
