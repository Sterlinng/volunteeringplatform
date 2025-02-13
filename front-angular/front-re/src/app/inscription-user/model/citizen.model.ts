export class Citizens {
    firstname: string;
    lastname: string;
    ZIP_code: string;
    phone_number: string;
    Point?: string; // Initialisé à "0" si non spécifié
    address: string;
    level?: number; // Initialisé à 0 si non spécifié
    Note?: number; // Initialisé à 0 si non spécifié
    login?: string; // Si nécessaire
    mail: string;
    password: string;
  
    constructor(
      firstname: string,
      lastname: string,
      ZIP_code: string,
      phone_number: string,
      address: string,
      password: string,
      Point: string = "0", // Valeur par défaut à "0"
      level: number = 0, // Valeur par défaut à 0
      mail: string,
      Note: number = 0, // Valeur par défaut à 0
      login?: string,
    ) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.ZIP_code = ZIP_code;
      this.phone_number = phone_number;
      this.address = address;
      this.password = password;
      this.Point = Point;
      this.level = level;
      this.Note = Note;
      this.login = login;
      this.mail = mail; // Notez que l'initialisation de l'ID à 0 peut ne pas être nécessaire si votre backend attribue un ID.
    }
  }
  