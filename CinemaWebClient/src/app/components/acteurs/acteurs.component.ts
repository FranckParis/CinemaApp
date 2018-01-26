import { Component, OnInit } from '@angular/core';
import {ActeursProvider} from '../../providers/acteursProvider';
import {Acteur} from '../../models/acteur';

@Component({
  selector: 'app-acteurs',
  templateUrl: './acteurs.component.html',
  styleUrls: ['./acteurs.component.css']
})
export class ActeursComponent implements OnInit {

  acteurs: Acteur[] = [];
  acteur: Acteur;

  constructor(private acteursProvider: ActeursProvider) { }

  ngOnInit() {
    this.acteur = new Acteur(null, null, null, null, null);
    this.acteursProvider.getAll().subscribe(acteurs => {
      this.acteurs = acteurs;
    });
  }

  delete(id: any) {
    this.acteursProvider.delete(id).subscribe( ret => {
      console.log(ret);
    });
  }

  add(acteur: Acteur) {
    this.acteursProvider.add(acteur).subscribe( ret => {
      console.log(ret);
    });
  }

}
