import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { PDFDocument, rgb } from 'pdf-lib';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-my-account',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './my-account.component.html',
  styleUrl: './my-account.component.sass'
})

export class MyAccountComponent implements OnInit {
  citizen: any = {};
  isEditing: boolean = false;

  certificatImagePath = '../../assets/certificat.pdf';

  constructor(private http: HttpClient, private router: Router) { }

  async downloadPDF(): Promise<void> {
    const pdfPath = this.certificatImagePath;
    const existingPdfBytes = await fetch(pdfPath).then((res) => res.arrayBuffer());
    const pdfDoc = await PDFDocument.load(existingPdfBytes);
    const page = pdfDoc.getPage(0);

    const fontSize = 12;
    const textColor = rgb(0, 0, 0);

    page.drawText(this.citizen.firstname + " " + this.citizen.lastname, {
      x: 250,
      y: 392,
      size: fontSize,
      color: textColor,
    });
    const todayDate = new Date().toLocaleDateString();
    page.drawText(todayDate, {
      x: 265,
      y: 375,
      size: fontSize,
      color: textColor,
    });

    page.drawText(this.citizen.level.toString(), {
      x: 360,
      y: 280,
      size: 40,
      color: textColor,
    });

    page.drawText(todayDate, {
      x: 380,
      y: 76,
      size: fontSize,
      color: textColor,
    });

    page.drawText("Bordeaux", {
      x: 260,
      y: 76,
      size: fontSize,
      color: textColor,
    });

    

    const pdfBytes = await pdfDoc.save();
    const blob = new Blob([pdfBytes], { type: 'application/pdf' });
    saveAs(blob, 'certificat.pdf');
  }
  

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (userId) {
      this.http.get(`http://localhost:8080/citizen/getCitizenById/${userId}`).subscribe((citizen: any) => {
        this.citizen = citizen;
      });
    }
  }

  enableEditing(): void {
    this.isEditing = true;
  }

  updateCitizen(): void {
    const userId = localStorage.getItem('userId');
    if (userId && this.isEditing) {
      this.http.put(`http://localhost:8080/citizen/updateCitizen/${userId}`, this.citizen)
        .subscribe({
          next: (updatedCitizen: any) => {
            this.citizen = updatedCitizen;
            this.isEditing = false;
          },
          error: (error) => {
            console.error('Error updating citizen:', error);
          }
        });
    }
  }

  deleteAccount(): void {
    const userId = localStorage.getItem('userId');
    if (userId) {
      this.http.delete(`http://localhost:8080/citizen/deleteCitizen/${userId}`)
        .subscribe({
          next: () => {
            console.log("Compte supprimé avec succès");
            localStorage.removeItem('userId');
            this.router.navigate(['/']);
          },
          error: (error) => {
            console.error('Erreur lors de la suppression du compte:', error);
          }
        });
    }
  }

  onLogout(): void {
    localStorage.removeItem('token');
    console.log('Token JWT supprimé');
    this.router.navigate(['/connexion-user']);
  }
}
