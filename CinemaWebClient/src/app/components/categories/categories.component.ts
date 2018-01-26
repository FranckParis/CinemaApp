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
  categorie: Categorie;

  constructor(private categorieProvider: CategorieProvider) { }

  ngOnInit() {
    this.categorie = new  Categorie(null, null);
    this.categorieProvider.getAll().subscribe(categories => this.categories = categories);
  }

  delete(id: any) {
    this.categorieProvider.delete(id).subscribe( ret => {
      console.log(ret);
    });
  }

  add(categorie: Categorie) {
    this.categorieProvider.add(categorie).subscribe(ret => {
      console.log(ret);
    });
  }

}
