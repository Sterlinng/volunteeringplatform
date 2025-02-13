package org.acme.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Certificate {

    @Id
    public int id_certificate;
    public String wording;
    public String name;
    public Date date_certificate;

    public Certificate(){
        
    }


    public Certificate(int id_certificate, String wording, String name, Date date_certificate) {
        this.id_certificate = id_certificate;
        this.wording = wording;
        this.name = name;
        this.date_certificate = date_certificate;
    }

}
