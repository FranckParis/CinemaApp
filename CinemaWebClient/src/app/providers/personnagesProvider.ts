import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Personnage} from '../models/personnage';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class PersonnagesProvider {

  constructor(private http: Http) {  }

  getPersonnages(): Observable<Personnage[]> {
    const url = `http://localhost:8080/personnages`;
    return this.http.get(url).map(response => response.json()._embedded.personnages as Personnage[]);
  }

}
