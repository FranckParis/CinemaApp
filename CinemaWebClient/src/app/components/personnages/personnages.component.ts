import { Component, OnInit } from '@angular/core';
import {Personnage} from '../../models/personnage';
import {PersonnagesProvider} from '../../providers/personnagesProvider';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css']
})
export class PersonnagesComponent implements OnInit {

  personnages: Personnage[];

  constructor(private personnageProvider: PersonnagesProvider) { }

  ngOnInit() {
    this.personnageProvider.getPersonnages().subscribe(personnages => this.personnages = personnages);
  }

}
