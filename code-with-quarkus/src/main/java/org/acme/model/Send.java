package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Send {

    @Id
    public int id_send;
    public String notice_user;

    public Send(){
        
    }

    public Send(int id_send, String notice_user) {
        this.notice_user = notice_user;
    }

}
