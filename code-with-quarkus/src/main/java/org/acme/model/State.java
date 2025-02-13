package org.acme.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_state;
    public String wording;
    public Date date_state;

    public State(){

    }

    public State(Integer id_state, String wording, Date date_state) {
        this.id_state = id_state;
        this.wording = wording;
        this.date_state = date_state;
    }

    public State(Date date_state, String wording) {
        this.wording = wording;
        this.date_state = date_state;
    }
}

  
