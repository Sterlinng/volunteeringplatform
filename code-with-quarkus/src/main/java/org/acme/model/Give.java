package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Give {

    @Id
    public int id_give;
    public String notice_mission;

    public Give(){
        
    }


    public Give(int id_give, String notice_mission) {
        this.id_give = id_give;
        this.notice_mission = notice_mission;
    }

}
