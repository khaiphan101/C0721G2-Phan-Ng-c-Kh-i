import {Component, OnInit} from '@angular/core';
import {FormCreate} from "../form-create";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  formCreate: FormGroup;
  form: FormCreate;
  countryList: string[] = ['Florida', 'South Dakota', 'Tennessee', 'Michigan', 'New York']

  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

    this.formCreate = this._formBuilder.group({
      email: ['', [Validators.required]],
      passwordGroup: [{
        password: [],
        passwordConfirm: []
      }, {validator: passwordNotMatch}],
      password: [''],
      country: ['', [Validators.required]],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });
  }

  onSubmit() {
    console.log(this.formCreate.value);
    console.log(this.formCreate.valid);
  }
}
function passwordNotMatch(control: AbstractControl) {
  const formControl = control.value;
  return formControl.password === formControl.passwordConfirm ? null : {passwordNotMatch: true};
}
