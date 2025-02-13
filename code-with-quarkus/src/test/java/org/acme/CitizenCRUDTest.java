package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;



@QuarkusTest
public class CitizenCRUDTest {

    @Inject
    ICitizenMgtService svc;

    @Test
    public void testCreateCitizen() {
        Citizens citizen = new Citizens();
        citizen.firstname = "theo";
        citizen.lastname = "FODIL-CHERIF";
        citizen.ZIP_code = "33700";
        citizen.phone_number = "0622639026";
        citizen.Point = "15";
        citizen.address = "merignac";
        citizen.level = 10;
        citizen.Note = 5;
        citizen.mail = "afodil@gmail.com";
        citizen.login = "aminefodil";
        citizen.password = "aminefodil";
        Citizens newCtiz = svc.createCitizen(citizen);

        assertNotNull(newCtiz);
    }

    @Test
    public void testReadCitizen() {
        // Assuming there is a citizen with ID 1 in the database.
        int testId = 8;
        Citizens foundCitizen = svc.getCitizenById(testId);
        assertNotNull(foundCitizen, "Citizen should not be null");
    }

    @Test
    public void testUpdateCitizen() {
        // Assuming there is a citizen with ID 1 in the database.
        int testId = 8;
        Citizens originalCitizen = svc.getCitizenById(testId);
        assertNotNull(originalCitizen);

        // Update information
        originalCitizen.firstname = "Updated Name";
        Citizens updatedCitizen = svc.updateCitizen(testId, originalCitizen);
        assertEquals("Updated Name", updatedCitizen.firstname, "Names should match after update.");
    }

    @Test
    public void testDeleteCitizen() {
        // Assuming there is a citizen with ID 1 in the database.
        int testId = 1;
        svc.deleteCitizen(testId);

        // Attempt to retrieve the deleted citizen
        Citizens deletedCitizen = svc.getCitizenById(testId);
        assertNull(deletedCitizen, "Citizen should be null after deletion.");
    }

    @Test
    public void testSuccessfulAuthentication() {
        // Attempt to authenticate
        Citizens authenticatedCitizen = svc.authenticateCitizen("aminefodil", "aminefodil");
        assertNotNull(authenticatedCitizen, "Authentication should succeed with correct credentials");
    }

    @Test
    public void testAuthenticationWithWrongPassword() {
        Citizens authenticatedCitizen = svc.authenticateCitizen("aminefodil", "wrongPassword");
        assertNull(authenticatedCitizen, "Authentication should fail with wrong password");
    }

    @Test
    public void testAuthenticationWithNonexistentLogin() {
        Citizens authenticatedCitizen = svc.authenticateCitizen("nonexistentLogin", "anyPassword");
        assertNull(authenticatedCitizen, "Authentication should fail with nonexistent login");
    }
}