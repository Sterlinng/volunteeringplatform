package org.acme.services.management.impl;

import java.util.List;

import org.acme.model.Mission;
import org.acme.services.management.IMissionMgtService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MissionMgtService implements IMissionMgtService{
    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Mission createMission(Mission mission) {
        // Merge the detached entity to reattach it to the persistence context
        Mission mergedMission = entityManager.merge(mission);
        // Now persist the merged entity
        entityManager.persist(mergedMission);
        return mergedMission;
    }

    @Override
    @Transactional
    public Mission getMissionById(int missionId) {
        return entityManager.find(Mission.class, missionId);
    }

    @Override
    @Transactional
    public List<Mission> getAllMissions() {
        return entityManager.createQuery("SELECT m FROM Mission m", Mission.class).getResultList();
    }

    @Override
    @Transactional
    public Mission updateMission(int missionId, Mission updatedMission) {
        Mission existingMission = entityManager.find(Mission.class, missionId);
        if (existingMission != null) {
            existingMission.wording = updatedMission.wording;
            existingMission.date_mission = updatedMission.date_mission;
            existingMission.name = updatedMission.name;
            existingMission.note = updatedMission.note;
            existingMission.ZIP_code = updatedMission.ZIP_code;
            existingMission.address = updatedMission.address;
            existingMission.beginning_hour = updatedMission.beginning_hour;
            existingMission.end_time = updatedMission.end_time;
            existingMission.description = updatedMission.description;
        }
        return existingMission;
    }

    @Override
    @Transactional
    public void deleteMission(int missionId) {
        Mission missionToDelete = entityManager.find(Mission.class, missionId);
        if (missionToDelete != null) {
            entityManager.remove(missionToDelete);
        }
    }
}
