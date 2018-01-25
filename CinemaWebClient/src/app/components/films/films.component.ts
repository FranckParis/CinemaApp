import { Component, OnInit } from '@angular/core';
import { FilmsProvider } from '../../providers/filmsProvider';
import { Film } from '../../models/film';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  films: Film[];

  constructor(private filmsProvider: FilmsProvider) { }

  ngOnInit() {
    this.filmsProvider.getAll().subscribe(films => {
      this.films = films;
    });
  }

}
