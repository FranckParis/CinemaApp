import { Component, OnInit } from '@angular/core';
import {Categorie} from '../../models/categorie';
import {CategorieProvider} from '../../providers/categorieProvider';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories: Categorie[];

  constructor(private categorieProvider: CategorieProvider) { }

  ngOnInit() {
    this.categorieProvider.getAll().subscribe(categories => this.categories = categories);
  }

}
