export class Corporation {
    name: string;
    Siret: string;
    Siren: string;
    mail: string;
    password: string;
    address: string;
    phone_number: string;
    ZIP_code: string;
    login?: string; // Si nécessaire
    note?: number; // Initialisé à "0" si non spécifié


    constructor(
    name: string,
    Siret: string,
    Siren: string,
    mail: string,
    address: string,
    phone_number: string,
    ZIP_code: string,
    password: string,
    login?: string,
    note?: number,
    ) {
      this.name = name;
      this.Siret = Siret;
      this.Siren = Siren;
      this.mail = mail;
      this.note = note;
      this.address = address;
      this.phone_number = phone_number;
      this.ZIP_code = ZIP_code;
      this.login = login;
      this.password = password;
    }
  }
