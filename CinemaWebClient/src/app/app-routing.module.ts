import { NgModule } from '@angular/core';
import {RouterModule, Route, Router} from '@angular/router';
import { FilmsComponent } from './components/films/films.component';
import { RealisateursComponent } from './components/realisateurs/realisateurs.component';


const routes: Route[] = [
  {path: 'films', component: FilmsComponent},
  {path: 'realisateurs', component: RealisateursComponent}
];


@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
