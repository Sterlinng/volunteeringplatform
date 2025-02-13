package org.acme.resource.api.dto;

public class ConnectionCorporationDTO {
    
    public String login; 
    public String password;


    public ConnectionCorporationDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
