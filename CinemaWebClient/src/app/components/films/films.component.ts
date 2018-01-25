import { Component, OnInit } from '@angular/core';
import { FilmsProvider } from '../../providers/filmsProvider';
import { Film } from '../../models/film';
import {Categorie} from '../../models/categorie';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  films: Film[] = [];

  constructor(private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    this.filmsProvider.getAll().subscribe(films => {
      this.parseFilms(films);
    });
  }

  parseFilms(films: any) {
    films.forEach((film) => {
      const titre = film.titre;
      const duree = film.duree;
      const dateSortie = film.dateSortie;
      const budget = film.budget;
      const montantRecette = film.montantRecette;
      let libelleCat;
      this.filmsProvider.getCategorie(film._links.categorieByCodeCat.href).subscribe(categorie => {
        libelleCat = categorie.libelleCat;
        this.films.push(new Film(titre, duree, dateSortie, budget, montantRecette, libelleCat));
      });
    });
  }

}
