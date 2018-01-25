import { Component, OnInit } from '@angular/core';
import {FilmsProvider} from '../../../providers/filmsProvider';
import { Film } from '../../../models/film';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  film: Film;

  constructor(private route: ActivatedRoute, private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    this.getFilm();
  }

  getFilm() {
    const id: number = +this.route.snapshot.paramMap.get('id');
    this.filmsProvider.getById(id).subscribe(film => {
      this.parseFilm(film);
    });
  }

  parseFilm(film: any) {
    const noFilm = film.noFilm;
    const titre = film.titre;
    const duree = film.duree;
    const dateSortie = film.dateSortie;
    const budget = film.budget;
    const montantRecette = film.montantRecette;
    let libelleCat;
    this.filmsProvider.getCategorie(film._links.categorieByCodeCat.href).subscribe(categorie => {
      libelleCat = categorie.libelleCat;
      this.film = new Film(noFilm, titre, duree, dateSortie, budget, montantRecette, libelleCat);
    });
  }

}
