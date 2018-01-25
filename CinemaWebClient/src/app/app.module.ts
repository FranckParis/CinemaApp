import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { FilmsComponent } from './components/films/films.component';

import { FilmsProvider } from './providers/filmsProvider';
import { RealisateursComponent } from './components/realisateurs/realisateurs.component';
import {RealisateursProvider} from './providers/realisateursProvider';
import { PersonnagesComponent } from './components/personnages/personnages.component';
import {PersonnagesProvider} from './providers/personnagesProvider';
import { ActeursComponent } from './components/acteurs/acteurs.component';


@NgModule({
  declarations: [
    AppComponent,
    FilmsComponent,
    RealisateursComponent,
    PersonnagesComponent,
    ActeursComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [
    FilmsProvider,
    RealisateursProvider,
    PersonnagesProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
