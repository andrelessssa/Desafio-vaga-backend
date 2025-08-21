import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // Aqui é onde ficam as propriedades da classe
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getAnuncios(){
    return this.http.get(`${this.baseUrl}/anuncio`);
  }

}
