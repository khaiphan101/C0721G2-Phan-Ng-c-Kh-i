import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerService} from "../../../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerType} from "../../../model/customer-type";
import {Customer} from "../../../model/customer";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  customerId: any;
  customer: Customer;
  constructor(private _formBuilder: FormBuilder,
              public customerService: CustomerService,
              public activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(data => {
      this.customerId = data.id;
      this.customerService.findCustomerById(this.customerId).subscribe(data => {
        this.customer = data;
        console.log(this.customer);
      });
    });

  }

}
