import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  editSubmit() {
      const product = this.productForm.value;
      this.productService.editProduct(product, index);
      this.productForm.reset();
  }
}
