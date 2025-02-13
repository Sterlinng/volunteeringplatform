package org.acme.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Citizens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_citizens;
    
    public String lastname;
    public String firstname;
    public String ZIP_code;
    public String phone_number;
    public String Point;
    public String address;
    public int level;
    public int Note;
    public String mail;

    public String login;

    public String password;

    public Citizens(){
        
    }

    public Citizens(
        int id_citizens, String firstname, String lastname, String ZIP_code, String phone_number,
        String Point, String address, int level, int Note, String login, String password, String mail) {

            this.id_citizens = id_citizens;
            this.firstname = firstname;
            this.lastname = lastname;
            this.ZIP_code = ZIP_code;
            this.phone_number = phone_number;
            this.address = address;
            this.Point = Point;
            this.Note = Note;
            this.level = level;
            this.login = login;
            this.mail = mail;
            this.password = password;
    }


    @Override
    public String toString() {
        return "Citizens{" +
                "id=" + id_citizens +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}