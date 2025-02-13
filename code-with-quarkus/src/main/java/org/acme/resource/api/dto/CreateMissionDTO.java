package org.acme.resource.api.dto;

import java.sql.Date;
import java.sql.Time;

public class CreateMissionDTO {
    
    public String name;
    public String name_corporation;
    public String address; 
    public String ZIP_code;
    public Date date_mission;
    public Time beginning_hour;
    public Time end_hour;
    public String description;


    public CreateMissionDTO(String name, String name_corporation, String address, String ZIP_code, Date date_mission, Time beginning_hour, Time end_hour, String description) {
        this.name = name;
        this.name_corporation = name_corporation;
        this.address = address;
        this.ZIP_code = ZIP_code;
        this.date_mission = date_mission;
        this.beginning_hour = beginning_hour;
        this.end_hour = end_hour;
        this.description = description;
    }

}
