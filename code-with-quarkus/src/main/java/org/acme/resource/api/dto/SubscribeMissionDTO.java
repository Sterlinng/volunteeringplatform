package org.acme.resource.api.dto;

public class SubscribeMissionDTO {
    
    public String firstname;
    public String lastname;
    public String name_mission;
    public String name_corporation;
    public String phone_number_user;
    public String phone_number_coporation;
    public String status;


    public SubscribeMissionDTO(String firstname, String lastname, String name_mission, String name_corporation, String phone_number_user, String phone_number_coporation, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.name_mission = name_mission;
        this.name_corporation = name_corporation;
        this.phone_number_user = phone_number_user;
        this.phone_number_coporation = phone_number_coporation;
        this.status = status;
    }

}
