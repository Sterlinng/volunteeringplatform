package org.acme.resource.api.dto;

public class ConnectionUserDTO {
    
    public String login;
    public String password;


    public ConnectionUserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
