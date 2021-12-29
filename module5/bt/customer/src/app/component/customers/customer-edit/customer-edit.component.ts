import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../../services/customer.service";
import {CustomerType} from "../../../model/customer-type";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  formEdit: FormGroup;
  customerId: any;
  customerTypeList: CustomerType[];


  constructor(private _formBuilder: FormBuilder,
              public  customerService: CustomerService,
              public router: Router,
              public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerTypes().subscribe(data => {
        this.customerTypeList = data;
        console.log(this.customerTypeList);
      }
    );
    this.formEdit = this._formBuilder.group({
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
    this.activatedRoute.params.subscribe(data => {
      this.customerId = data.id;
      this.customerService.findCustomerById(this.customerId).subscribe(data => {
        this.formEdit.patchValue(data);
        console.log(data);
      });
    });
  }

  compareFn(c1: CustomerType, c2: CustomerType): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    console.log(this.formEdit.value);
    console.log(this.formEdit.value.customer_type);
    this.customerService.editCustomer(this.formEdit.value, this.customerId).subscribe(data => {
      alert('Edit customer successfully');
      this.router.navigateByUrl('customer/list');
    });
  }
}
