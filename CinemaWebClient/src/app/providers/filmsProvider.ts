import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';
import {Film} from '../models/film';
import {Categorie} from '../models/categorie';

@Injectable()
export class FilmsProvider {
  constructor(private http: Http) {}

  getAll(): Observable<Film[]> {
    const url = `http://localhost:8080/films`;
    return this.http.get(url).map(response => response.json()._embedded.films as Film[]);
  }

  getById(id: any): Observable<Film> {
    const url = `http://localhost:8080/films/${id}`;
    return this.http.get(url).map(response => response.json() as Film);
  }

  getCategorie(url: string): Observable<Categorie> {
    return this.http.get(url).map(response => response.json() as Categorie);
  }

  getByIdRea(id: number): string[] {
    const response: string[] = [];
    const allFilms = this.getAll();
    allFilms.forEach((films) => {
      films.forEach((film) => {
        if (film.noFilm === id) {
          response.push(film.titre);
        }
      });
    });
    return response;
  }
}
