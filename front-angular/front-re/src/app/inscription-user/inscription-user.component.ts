import { Component } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Citizens } from './model/citizen.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-inscription-user',
  templateUrl: './inscription-user.component.html',
  imports: [FormsModule, HttpClientModule, CommonModule],
  styleUrls: ['./inscription-user.component.sass'],
  standalone: true,
})
export class InscriptionUserComponent {
  citizen = new Citizens('', '', '', '', '', '', "0", 0, '');
  isPasswordValid: boolean = false;

  constructor(private http: HttpClient, private router: Router) { }
  

  formatPhoneNumber() {
    this.citizen.phone_number = this.citizen.phone_number.replace(/\s/g, '');
    this.citizen.phone_number = this.citizen.phone_number.replace(/(\d{2})(?=\d)/g, '$1 ');
  }

  isFormValid(): boolean {
    return !!this.citizen.firstname && !!this.citizen.lastname && !!this.citizen.ZIP_code &&
           !!this.citizen.phone_number && !!this.citizen.mail && !!this.citizen.address &&
           !!this.citizen.login && !!this.citizen.password;
  }

  isInvalidLogin(): boolean {
    if (this.citizen.login) {
      return (this.citizen.login.length > 0 && this.citizen.login.length < 8);
    }
    return false;
  }

  validatePassword(password: string): void {
    const passwordRegex: RegExp = /^(?=.*[A-Z])(?=.*[0-9]).{8,}$/;
    this.isPasswordValid = passwordRegex.test(password);
  }

  onSubmit(): void {
    if (this.isFormValid()) {
      console.log(this.citizen); 

      const httpOptions = {
        headers: new HttpHeaders({
          'Access-Control-Allow-Origin': 'http://localhost:8080'
        })
      };
  
      this.http.post<Citizens>('http://localhost:8080/citizen/createCitizen', this.citizen, httpOptions)
        .subscribe({
          next: (response) => console.log('Utilisateur créé avec succès !', response),
          error: (error) => console.error('Erreur lors de la création de l\'utilisateur :', error)
        });
      }
      this.router.navigate(['/connexion-user']);
    }
}
