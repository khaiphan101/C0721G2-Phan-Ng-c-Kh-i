import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];


  constructor(private productService: ProductService,
              private _router: Router) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.products = this.productService.getAll();
  }

  showUpdate(index: number) {
    this._router.navigate(['product/update', index]);
  }
}
