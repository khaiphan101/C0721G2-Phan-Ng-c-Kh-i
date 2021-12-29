import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer.service";
import {CustomerType} from "../../../model/customer-type";

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  formCreate: FormGroup;

  customerTypeList: CustomerType[];

  constructor(private _formBuilder: FormBuilder,
              public  customerService: CustomerService,
              public router: Router) { }

  ngOnInit(): void {
    this.customerService.getAllCustomerTypes().subscribe(data => {
        this.customerTypeList = data;
        console.log(this.customerTypeList);
      }
    );
    this.formCreate = this._formBuilder.group({
      fullName: ['', [Validators.required]],
      customer_type: ['', [Validators.required]],
      academicLevel: ['', [Validators.required]],
      part: ['', [Validators.required]],
      dateOfBirth: ['', [Validators.required]],
      salary: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]],
      address: ['', [Validators.required]]
    });
  }

  onSubmit() {
    console.log(this.formCreate.value);
    this.customerService.addNewCustomer(this.formCreate.value).subscribe(data =>{
      this.router.navigateByUrl('customer/list');
    });
  }

}
