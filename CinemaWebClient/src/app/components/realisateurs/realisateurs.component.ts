import { Component, OnInit } from '@angular/core';
import { Realisateur } from '../../models/realisateur';
import { RealisateursProvider } from '../../providers/realisateursProvider';
import { Subject } from 'rxjs/Subject';

@Component({
  selector: 'app-realisateurs',
  templateUrl: './realisateurs.component.html',
  styleUrls: ['./realisateurs.component.css']
})
export class RealisateursComponent implements OnInit {

  realisateur: Realisateur;
  realisateurs: Realisateur[];

  constructor(private realisateursProvider: RealisateursProvider) { }

  ngOnInit() {
    this.realisateur = new Realisateur(null, null, null, null);
    this.realisateursProvider.getRealisateurs().subscribe(realisateurs => this.realisateurs = realisateurs);
  }

  delete(id: any) {
    this.realisateursProvider.delete(id).subscribe( ret => {
      console.log(ret);
    });
  }

  add(realisateur: Realisateur) {
    this.realisateursProvider.add(realisateur).subscribe( ret => {
      console.log(ret);
    });
  }

}
