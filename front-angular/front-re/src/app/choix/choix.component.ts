import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choix',
  standalone: true,
  imports: [],
  templateUrl: './choix.component.html',
  styleUrl: './choix.component.sass'
})
export class ChoixComponent {

constructor(private router: Router) { }

redirectToCitizenPage(): void {
    this.router.navigate(['/inscription-user']);
  }

redirectToCorporationPage(): void {
    this.router.navigate(['/inscription-corp']);
  }
}
