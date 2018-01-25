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

  getById(id: number): Observable<Film> {
    const url = `http://localhost:8080/film/${id}`;
    return this.http.get(url).map(response => response.json() as Film);
  }

  getCategorie(url: string): Observable<Categorie> {
    return this.http.get(url).map(response => response.json() as Categorie);
  }
}
