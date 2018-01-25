import { Component, OnInit } from '@angular/core';
import { Realisateur } from '../../models/realisateur';
import { RealisateursProvider } from '../../providers/realisateursProvider';

@Component({
  selector: 'app-realisateurs',
  templateUrl: './realisateurs.component.html',
  styleUrls: ['./realisateurs.component.css']
})
export class RealisateursComponent implements OnInit {

  realisateurs: Realisateur[];

  constructor(private realisateursProvider: RealisateursProvider) { }

  ngOnInit() {
    this.realisateursProvider.getRealisateurs().subscribe(realisateurs => this.realisateurs = realisateurs);
  }

}
