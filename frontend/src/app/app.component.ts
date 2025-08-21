import { AnuncioService } from './services/anuncio/anuncio.service';
import { Component, OnInit } from '@angular/core';
import { Anuncio } from './services/anuncio/anuncio.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  anuncios : Anuncio[] = [];

  constructor(private anuncioService: AnuncioService){}

  ngOnInit(): void {
    this.anuncioService.getAnuncios().subscribe((res) => {
      this.anuncios = res
    });

  }

}
