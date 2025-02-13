package org.acme.resource.api.dto;

public class CreateCorporationDTO {
    
    public String name_corporation;
    public String Siret;
    public String Siren;
    public String address;
    public String ZIP_code;
    public String phone_number;
    public String login;
    public String password;


    public CreateCorporationDTO(String name_corporation, String Siret, String Siren, String address, String ZIP_code, String phone_number, String login, String password) {
        this.name_corporation = name_corporation;
        this.Siret = Siret;
        this.Siren = Siren;
        this.address = address;
        this.ZIP_code = ZIP_code;
        this.phone_number = phone_number;
        this.login = login;
        this.password = password;
    }

}
