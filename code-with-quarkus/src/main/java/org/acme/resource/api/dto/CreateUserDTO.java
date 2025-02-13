package org.acme.resource.api.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    
    public String firstname;
    public String lastname;
    public String address;
    public String ZIP_code;
    public String phone_number;
    public String login;
    public String password;


    public CreateUserDTO(String firstname, String lastname, String address, String ZIP_code, String phone_number, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.ZIP_code = ZIP_code;
        this.phone_number = phone_number;
        this.login = login;
        this.password = password;
    }


}
