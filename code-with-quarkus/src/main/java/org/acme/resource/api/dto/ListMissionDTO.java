package org.acme.resource.api.dto;

import java.sql.Date;

public class ListMissionDTO {
    
    public String name;
    public String description;
    public String name_corporation;
    public Date date_mission;


    public ListMissionDTO(String name, String description, String name_corporation, Date date_mission) {
        this.name = name;
        this.description = description;
        this.name_corporation = name_corporation;
        this.date_mission = date_mission;
    }

}
