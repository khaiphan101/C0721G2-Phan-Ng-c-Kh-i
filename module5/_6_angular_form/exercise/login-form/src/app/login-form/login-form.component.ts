import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  formLogin : FormGroup
  constructor(private _formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.formLogin = this._formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }

  onSubmit(){
    console.log(this.formLogin.value);
    console.log(this.formLogin.valid);
  }
}
