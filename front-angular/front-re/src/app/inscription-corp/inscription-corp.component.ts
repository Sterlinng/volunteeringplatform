import { Component } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Corporation } from './model/corporation.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inscription-corp',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './inscription-corp.component.html',
  styleUrl: './inscription-corp.component.sass'
})
export class InscriptionCorpComponent {
  corporation = new Corporation('', '', '', '', '', '', '', '', '', );
  isPasswordValid: boolean = false;

  constructor(private http: HttpClient) { }

  formatPhoneNumber() {
    this.corporation.phone_number = this.corporation.phone_number.replace(/\s/g, '');
    this.corporation.phone_number = this.corporation.phone_number.replace(/(\d{2})(?=\d)/g, '$1 ');
  }

  isInvalidSiret(): boolean {
    const siretRegex: RegExp = /^\d{14}$/;
    return !!this.corporation.Siret && !siretRegex.test(this.corporation.Siret);
  }

  isInvalidSiren(): boolean {
    const sirenRegex: RegExp = /^\d{9}$/;
    return !!this.corporation.Siren && !sirenRegex.test(this.corporation.Siren);
  }

  isFormValid(): boolean {
    return !!this.corporation.name && !!this.corporation.Siret && !!this.corporation.Siren &&
           !!this.corporation.mail && !!this.corporation.address && !!this.corporation.phone_number &&
           !!this.corporation.ZIP_code && !!this.corporation.login && !!this.corporation.password;
  }

  validatePassword(password: string): void {
    const passwordRegex: RegExp = /^(?=.*[A-Z])(?=.*[0-9]).{8,}$/;
    this.isPasswordValid = passwordRegex.test(password);
  }

  isInvalidLogin(): boolean {
    if (this.corporation.login) {
      return (this.corporation.login.length > 0 && this.corporation.login.length < 8);
    }
    return false;
  }

  onSubmit(): void {
    if (this.isFormValid()) {
      console.log(this.corporation);

      const httpOptions = {
        headers: new HttpHeaders({
          'Access-Control-Allow-Origin': 'http://localhost:8080'
        })
      };
  
      this.http.post<Corporation>('http://localhost:8080/corporation/createCorporation', this.corporation, httpOptions)
        .subscribe({
          next: (response) => console.log('Corporation créé avec succès !', response),
          error: (error) => console.error('Erreur lors de la création de la corp :', error)
        });
    }
  }
}
