package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.model.Corporation;
import org.acme.services.management.ICorporationMgtService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@QuarkusTest
public class CorporationCRUDTest {

    @Inject
    ICorporationMgtService testCorp;

    @Test
    public void testCreateCorporation() {
        Corporation corporation = new Corporation();
        corporation.name = "theo";
        corporation.Siret = "FODIL-CHERIF";
        corporation.Siren = "DZFEEFE";
        corporation.mail = "testmail";
        corporation.note = 3;
        corporation.address = "15 rue de là bas";
        corporation.phone_number = "0622639026";
        corporation.ZIP_code = "33700";
        corporation.login = "aminefodil";
        corporation.password = "aminefodil";
        Corporation newCorp = testCorp.createCorporation(corporation);

        assertNotNull(newCorp);
    }

    @Test
    public void testGetAllCorporations() {
        List<Corporation> corporations = testCorp.getAllCorporations();
        assertNotNull(corporations, "Corporations list should not be null");
        assertFalse(corporations.isEmpty(), "Corporations list should not be empty");
    }

    @Test
    public void testGetCorporationById() {
        Corporation corporation = testCorp.getCorporationById(3);
        assertNotNull(corporation, "Corporation should not be null");
        assertEquals(3, corporation.id_corporation);
    }

    @Test
    public void testUpdateCorporation() {
        Corporation updated = new Corporation();
        updated.name = "Updated Name";
        updated.Siret = "Updated SIRET";
        updated.Siren = "Updated SIREN";
        updated.mail = "updated@testmail.com";
        updated.note = 5;
        updated.address = "Updated address";
        updated.phone_number = "Updated phone number";
        updated.ZIP_code = "Updated ZIP code";
        updated.login = "Updated login";
        updated.password = "Updated password";

        Corporation result = testCorp.updateCorporation(1, updated);
        assertNotNull(result);
        assertEquals("Updated Name", result.name);
    }

    @Test
    public void testDeleteCorporation() {
        assertDoesNotThrow(() -> testCorp.deleteCorporation(1), "Delete should not throw any exception");
    }
}
