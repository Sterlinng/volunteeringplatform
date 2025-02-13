package org.acme.services.management.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.Certificate;
import org.acme.services.management.ICertificateMgtService;

import java.util.List;

@ApplicationScoped
public class CertificateMgtService implements ICertificateMgtService {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Certificate createCertificate(Certificate newCertificate){

        Certificate createCertificate = new Certificate();

        createCertificate.id_certificate = newCertificate.id_certificate;
        createCertificate.date_certificate = newCertificate.date_certificate;
        createCertificate.name = newCertificate.name;
        createCertificate.wording = newCertificate.wording;

        entityManager.persist(createCertificate);

        return createCertificate;
    }

    @Override
    @Transactional
    public Certificate getCertificateById(Integer certificateId){
        return entityManager.find(Certificate.class, certificateId);
    }

    @Override
    @Transactional
    public List<Certificate> getAllCertificate(){
        return entityManager.createQuery("SELECT c FROM Certificate c", Certificate.class).getResultList();
    }

    @Override
    @Transactional
    public Certificate updateCertificate(Integer certificateId, Certificate updateCertificate){
        Certificate existingCertificate = entityManager.find(Certificate.class, certificateId);
        if (existingCertificate != null){
            existingCertificate.name = updateCertificate.name;
            existingCertificate.id_certificate = updateCertificate.id_certificate;
            existingCertificate.date_certificate = updateCertificate.date_certificate;
            existingCertificate.wording = updateCertificate.wording;
        }
        return updateCertificate;
    }

    @Override
    @Transactional
    public void deleteCertificate(Integer certificateId){
        Certificate certificateToDelete = entityManager.find(Certificate.class, certificateId);
        if (certificateToDelete != null){
            entityManager.remove(certificateToDelete);
        }
    }
}
