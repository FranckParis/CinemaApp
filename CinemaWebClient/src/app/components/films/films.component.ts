import { Component, OnInit } from '@angular/core';
import { FilmsProvider } from '../../providers/filmsProvider';
import { Film } from '../../models/film';
import {PersonnagesProvider} from '../../providers/personnagesProvider';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  films: Film[] = [];

  constructor(private filmsProvider: FilmsProvider, private personnagesProvider: PersonnagesProvider) { }

  ngOnInit() {
    this.filmsProvider.getAll().subscribe(films => {
      this.parseFilms(films);
    });
  }

  parseFilms(films: any) {
    films.forEach((film) => {
      const noFilm = film.noFilm;
      const titre = film.titre;
      const duree = film.duree;
      const dateSortie = film.dateSortie;
      const budget = film.budget;
      const montantRecette = film.montantRecette;
      this.filmsProvider.getCategorie(film._links.categorieByCodeCat.href).subscribe(categorie => {
        this.films.push(new Film(noFilm, titre, duree, dateSortie, budget, montantRecette, categorie, null));
      });
    });
  }

}
