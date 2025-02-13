import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitizenService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCitizenById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/citizen/getCitizenById/${id}`);
  }
}
