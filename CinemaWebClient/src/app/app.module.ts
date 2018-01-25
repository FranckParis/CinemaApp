import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { FilmsComponent } from './components/films/films.component';

import { FilmsProvider } from './providers/filmsProvider';
import { RealisateursComponent } from './components/realisateurs/realisateurs.component';


@NgModule({
  declarations: [
    AppComponent,
    FilmsComponent,
    RealisateursComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [
    FilmsProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
