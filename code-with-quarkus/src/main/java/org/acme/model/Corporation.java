package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Corporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_corporation;
    public String name;
    public String Siret;
    public String Siren;
    public String mail;
    public int note;
    public String address;
    public String phone_number;
    public String ZIP_code;
    public String login;
    public String password;

    public Corporation(){
        
    }

    public Corporation(int id_corporation, String name, String Siret, String Siren, int note, 
        String address, String phone_number, String ZIP_code, String login, String password, String mail){
            this.id_corporation = id_corporation;
            this.name = name;
            this.Siret = Siret;
            this.Siren = Siren;
            this.note = note;
            this.address = address;
            this.phone_number = phone_number;
            this.ZIP_code = ZIP_code;
            this.login = login;
            this.password = password;
            this.mail = mail;

    }
}
