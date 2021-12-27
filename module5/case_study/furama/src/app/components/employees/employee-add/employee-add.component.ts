import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {
  formCreate: FormGroup;
  positionList: any;

  constructor(private _formBuilder: FormBuilder,
              public  employeeService: EmployeeService,
              public router: Router) { }

  ngOnInit(): void {
    this.employeeService.getAllPositions().subscribe(data => {
        this.positionList = data;
        console.log(this.positionList);
      }
    )
    this.formCreate = this._formBuilder.group({
      fullName: ['', [Validators.required]],
      position: ['123456'],
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
    this.employeeService.addNewEmployee(this.formCreate.value).subscribe(data =>{
      this.router.navigateByUrl('employee/list');
      })
  }
}
