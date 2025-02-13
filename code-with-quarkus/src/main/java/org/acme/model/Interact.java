package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Interact {

    @Id
    public int id_interact;
    public String Status;

    public Interact(){

    }


    public Interact(int id_interact, String Status) {
        this.id_interact = id_interact;
        this.Status = Status;
    }

}
