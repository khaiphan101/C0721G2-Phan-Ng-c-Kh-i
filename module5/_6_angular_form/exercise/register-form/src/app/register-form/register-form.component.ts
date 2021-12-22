import { Component, OnInit } from '@angular/core';
import {FormGroup} from "../form-group";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  forms: FormGroup[] = [];
  content = new FormControl();
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {

  }
}
