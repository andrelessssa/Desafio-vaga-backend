import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Anuncio } from './anuncio.model';

@Injectable({
  providedIn: 'root'
})
export class AnuncioService {

  private apiUrl = 'http://localhost:8080/anuncio';

  constructor(private http: HttpClient) { }


  createAnuncio(anuncio : any){
    return this.http.post(this.apiUrl, anuncio);
  }
  getAnuncios(): Observable<Anuncio[]> {
  return this.http.get<Anuncio[]>(this.apiUrl);
}
}
