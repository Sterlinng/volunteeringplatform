package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;

import org.acme.model.Corporation;
import org.acme.model.Mission;
import org.acme.model.State;
import org.acme.services.management.ICorporationMgtService;
import org.acme.services.management.IMissionMgtService;
import org.acme.services.management.IStateMgtService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MissionPostTest {

    @Inject
    IMissionMgtService missionService;
    @Inject
    ICorporationMgtService corporationService;
    @Inject
    IStateMgtService stateService;
    
    @Test
    public void testCreateAndRetrieveMission() {

        // Création et persistance de l'état
        State state = new State(Date.valueOf("2024-05-01"), "Some State");
        state = stateService.createState(state);

        // Création et persistance de la corporation
        Corporation corporation = new Corporation(1, "Example Corporation", "123456789", "987654321", 5,
                "123 Main St", "1234567890", "12345", "example_login", "example_password", "example@example.com");
        corporation = corporationService.createCorporation(corporation);

        // Création d'une nouvelle mission
        Mission newMission = new Mission();
        newMission.id_mission = 1;
        newMission.wording = "Audit";
        newMission.date_mission = Date.valueOf("2024-05-01");
        newMission.name = "Audit annuel";
        newMission.note = 5;
        newMission.ZIP_code = "75001";
        newMission.address = "123 rue de Paris";
        newMission.beginning_hour = Time.valueOf("09:00:00");
        newMission.end_time = Time.valueOf("17:00:00");
        newMission.description = "Audit complet des comptes de l'entreprise.";
        newMission.state = state;
        newMission.corporation = corporation;

        // Persistance de la mission
        missionService.createMission(newMission);

        // Récupération de la mission
        Mission retrievedMission = missionService.getMissionById(1);

        // Assertions pour vérifier la création et la récupération
        assertNotNull(retrievedMission);
        assertEquals(newMission.name, retrievedMission.name);
    }
}
