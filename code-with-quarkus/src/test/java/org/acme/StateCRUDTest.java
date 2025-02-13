package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.acme.model.State;
import org.acme.services.management.IStateMgtService;
import org.junit.jupiter.api.Test;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class StateCRUDTest {
    @Inject
    IStateMgtService stateSvc;

    @Test
    public void testPersistState() {
        State newState = new State(Date.valueOf("2024-05-01"), "Hello");

        State persistedState = stateSvc.createState(newState);

        assertNotNull(persistedState);
        assertEquals("Hello", persistedState.wording);
        assertEquals(Date.valueOf("2024-05-01"), persistedState.date_state);
    }
}
