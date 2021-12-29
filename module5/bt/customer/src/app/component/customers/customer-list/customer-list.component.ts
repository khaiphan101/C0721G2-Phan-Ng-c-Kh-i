import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../../services/customer.service";

import {CustomerDeleteComponent} from "../customer-delete/customer-delete.component";
import {MatDialog} from "@angular/material/dialog";
import {Customer} from "../../../model/customer";


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers: Customer[];
  term: string;
  p: any;


  constructor(
    public  customerService: CustomerService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data => {
        this.customers = data;
        console.log(this.customers);
      }
    );
  }

  // Mở dialog nhận id và trả về đối tượng customer
  openDialog(id): void {
    console.log(id);
    // Trả về đối tượng customer
    this.customerService.findCustomerById(id).subscribe(customerData => {
      console.log(customerData);
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {customerData},
        // Khi bấm ra ngoài dialog khong bi mat di
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
