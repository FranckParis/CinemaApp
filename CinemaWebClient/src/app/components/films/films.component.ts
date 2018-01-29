import { Component, OnInit } from '@angular/core';
import { FilmsProvider } from '../../providers/filmsProvider';
import { Film } from '../../models/film';
import {FilmNew} from '../../models/film_new';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  film: FilmNew;
  films: Film[] = [];

  constructor(private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    this.film = new FilmNew(null, null, null, null, null, null, null, null);
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

  delete(id: any) {
    this.filmsProvider.delete(id).subscribe( ret => {
      console.log(ret);
    });
  }

  add(film: Film) {
    this.filmsProvider.add(film).subscribe( ret => {
      console.log(ret);
    });
  }

}
