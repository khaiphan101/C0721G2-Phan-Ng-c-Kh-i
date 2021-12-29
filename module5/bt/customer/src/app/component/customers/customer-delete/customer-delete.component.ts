import {Component, Inject, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer";
import {Subscription} from "rxjs";
import {CustomerService} from "../../../services/customer.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  id: number;
  customer: Customer;
  private subscription: Subscription;

  constructor(
    private customerService: CustomerService,
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {

    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.customerData.id);
    this.customer = this.data.customerData;
  }

  deleteCustomer() {
    this.subscription = this.customerService.deleteCustomer(this.customer.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
