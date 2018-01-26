import { Component, OnInit } from '@angular/core';
import {Personnage} from '../../models/personnage';
import {PersonnagesProvider} from '../../providers/personnagesProvider';
import {FilmsProvider} from '../../providers/filmsProvider';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css']
})
export class PersonnagesComponent implements OnInit {

  personnage: Personnage;
  personnages: Personnage[] = [];

  constructor(private personnageProvider: PersonnagesProvider, private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    this.personnage = new Personnage(null, null, null, null);
    this.personnageProvider.getPersonnages().subscribe(personnages => {
      this.parsePersonnages(personnages);
    });
  }

  parsePersonnages(personnages: any) {
    personnages.forEach((personnage) => {
      const noFilm = personnage.noFilm;
      const noAct = personnage.noAct;
      const nomPers = personnage.nomPers;
      this.filmsProvider.getById(noFilm).subscribe(film => {
        this.personnages.push(new Personnage(noFilm, noAct, nomPers, film.titre));
      });
    });
  }

  add(personnage: Personnage) {
    this.personnageProvider.add(personnage).subscribe( ret => {
      console.log(ret);
    });
  }

}
