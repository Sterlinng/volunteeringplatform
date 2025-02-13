package org.acme.model;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_mission;
    public String wording;
    public Date date_mission;
    public String name;
    public int note;
    public String ZIP_code;
    public String address;
    public Time beginning_hour;
    public Time end_time;
    public String description;


    @ManyToOne
    @JoinColumn(name = "id_state")
    public State state;

    @ManyToOne
    @JoinColumn(name = "id_corporation")
    public Corporation corporation;
    

    public Mission(){
        
    }
    
    public Mission(
        Date date_mission, String name, int note, String ZIP_code, String address, Time beginning_hour, 
        Time end_time, String description, int id_mission, String wording){

            this.date_mission = date_mission;
            this.name = name;
            this.note = note;
            this.ZIP_code = ZIP_code;
            this.address = address;
            this.beginning_hour = beginning_hour;
            this.end_time = end_time;
            this.description = description;
            this.id_mission = id_mission;
            this.wording = wording;

    }
}
