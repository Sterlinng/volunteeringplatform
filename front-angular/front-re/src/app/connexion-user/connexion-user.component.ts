import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common'; // Importez CommonModule

@Component({
  selector: 'app-connexion-user',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './connexion-user.component.html',
  styleUrls: ['./connexion-user.component.sass']
})
export class ConnexionUserComponent implements OnInit {
  user = { login: '', password: '' };
  isLoggedIn = false;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.checkLoginStatusAndRedirect();
  }

  checkLoginStatusAndRedirect(): void {
    if (localStorage.getItem('token')) {
      this.router.navigate(['/account']);
    }
  }

  onLogin(): void {
    this.http.post('http://localhost:8080/citizen/authenticate', this.user, { responseType: 'json' })
      .subscribe({
        next: (response: any) => {
          localStorage.setItem('token', response.token);
          localStorage.setItem('userId', response.id.toString());
          console.log(response.id);
          this.isLoggedIn = true;
          this.router.navigate(['/account']);
        },
        error: (error) => {
          console.error('Erreur lors de la tentative de connexion:', error);
        }
      });
  }

  onLogout(): void {
    localStorage.removeItem('token');
    console.log('Token JWT supprimé');
    this.router.navigate(['/connexion-user']);
    this.isLoggedIn = false;
  }

  redirectToChoixPage(): void {
    this.router.navigate(['/choix']);
  }

}

