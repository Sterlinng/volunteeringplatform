package org.acme.services.management;

import java.util.List;

import org.acme.model.Mission;

public interface IMissionMgtService {

    public Mission createMission(Mission mission);

    public Mission getMissionById(int missionId);

    public List<Mission> getAllMissions();

    public Mission updateMission(int missionId, Mission updatedMission);

    public void deleteMission(int missionId);


}
