import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Rx';
import {Categorie} from '../models/categorie';

@Injectable()
export class CategorieProvider {
  constructor(private http: Http) {}

  getAll(): Observable<Categorie[]> {
    const url = `http://localhost:8080/categories`;
    return this.http.get(url).map(response => response.json()._embedded.categories as Categorie[]);
  }
}
