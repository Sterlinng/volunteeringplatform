package org.acme.services.management;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Certificate;

import java.util.List;

@ApplicationScoped
public interface ICertificateMgtService {

    /**
     * Create a new certificate in the DataBase
     *
     * @param newCertificate
     * @return
     */
    public Certificate createCertificate(Certificate newCertificate);

    /**
     * Read a certificate by an id
     *
     * @param certificateId
     * @return
     */
    public Certificate getCertificateById(Integer certificateId);

    @Transactional
    List<Certificate> getAllCertificate();

    /**
     * Update a certificate information
     *
     * @param certificateId
     * @param updateCertificate
     * @return
     */
    public Certificate updateCertificate(Integer certificateId, Certificate updateCertificate);

    /**
     * Delete a certificate
     *
     * @param certificateId
     */
    public void deleteCertificate(Integer certificateId);
}
