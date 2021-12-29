import { Component, OnInit } from '@angular/core';
import {QuestionType} from "../../../../../../questions/src/app/model/question-type";
import {QuestionService} from "../../../../../../questions/src/app/service/question.service";
import {CinemaService} from "../../../service/cinema.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Movie} from "../../../model/movie";

@Component({
  selector: 'app-cinema-add',
  templateUrl: './cinema-add.component.html',
  styleUrls: ['./cinema-add.component.css']
})
export class CinemaAddComponent implements OnInit {
  formCreate: FormGroup;

  movies: Movie[];

  constructor(private _formBuilder: FormBuilder,
              public  cinemaService: CinemaService,
              public router: Router) { }

  ngOnInit(): void {
    this.cinemaService.getAllMovies().subscribe(data => {
        this.movies = data;
        console.log(this.movies);
      }
    );
    this.formCreate = this._formBuilder.group({
    showDate: ['', [Validators.required]],
      movie: ['', [Validators.required]],
      totalTicket: ['', [Validators.required]],
    });
  }

  onSubmit() {
    console.log(this.formCreate.value);
    if (this.formCreate.valid) {
      const mess = 'Add new cinema successfuly!';
      this.cinemaService.addNew(this.formCreate.value).subscribe(value => {
          this.router.navigate(['/cinema/list', mess]);
        },
        error => {
          console.log(error);
        });
    } else {
      console.log(this.formCreate);
    }
  }
}
