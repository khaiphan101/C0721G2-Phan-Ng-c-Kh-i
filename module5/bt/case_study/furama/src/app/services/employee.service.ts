import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API_employee: string = 'http://localhost:3000/employees';
  public API_position: string = 'http://localhost:3000/positions';

  constructor(public http: HttpClient) {
  }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.API_employee);
  }

  getAllPositions(): Observable<any> {
    return this.http.get(this.API_position);
  }

  addNewEmployee(employee): Observable<any> {
    return this.http.post(this.API_employee, employee);
  }
}
