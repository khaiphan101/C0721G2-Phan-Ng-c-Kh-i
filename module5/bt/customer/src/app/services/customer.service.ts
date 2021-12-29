import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public api_customer: string = 'http://localhost:3000/customers';
  public api_customerType: string = 'http://localhost:3000/customerTypes';

  constructor(public http: HttpClient) {
  }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.api_customer);
  }

  getAllCustomerTypes(): Observable<any> {
    return this.http.get(this.api_customerType);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.api_customer, customer);
  }


  findCustomerById(id: any): Observable<Customer>  {
    return this.http.get<Customer>(this.api_customer + '/' + id);
  }

  deleteCustomer(id: number): Observable<Customer>  {
    return this.http.delete<Customer>(this.api_customer + '/' + id);
  }
  editCustomer(customer, customerId): Observable<any>  {
    return this.http.put(this.api_customer + '/' + customerId, customer);
  }
}
