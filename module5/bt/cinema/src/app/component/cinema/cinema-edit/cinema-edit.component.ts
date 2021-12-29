import { Component, OnInit } from '@angular/core';
import {QuestionType} from "../../../../../../questions/src/app/model/question-type";
import {QuestionService} from "../../../../../../questions/src/app/service/question.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CinemaService} from "../../../service/cinema.service";
import {Movie} from "../../../model/movie";

@Component({
  selector: 'app-cinema-edit',
  templateUrl: './cinema-edit.component.html',
  styleUrls: ['./cinema-edit.component.css']
})
export class CinemaEditComponent implements OnInit {
  formEdit: FormGroup;
  showCinemaId: any;
  movies: Movie[];


  constructor(private _formBuilder: FormBuilder,
              public  cinemaService: CinemaService,
              public router: Router,
              public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.cinemaService.getAllMovies().subscribe(data => {
        this.movies = data;
        console.log(this.movies);
      }
    );
    this.formEdit = this._formBuilder.group({
      showDate: ['', [Validators.required]],
      movie: ['', [Validators.required]],
      totalTicket: ['', [Validators.required]],
    });
    this.activatedRoute.params.subscribe(data => {
      this.showCinemaId = data.id;
      this.cinemaService.findById(this.showCinemaId).subscribe(data => {
        this.formEdit.patchValue(data);
        console.log(data);
      });
    });
  }

  compareFn(c1: Movie, c2: Movie): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    console.log(this.formEdit.value);
    console.log(this.formEdit.value.movie);
    if (this.formEdit.valid) {
      const mess = 'Edit cinema successfuly!';
      this.cinemaService.edit(this.formEdit.value, this.showCinemaId).subscribe(value => {
          this.router.navigate(['/cinema/list', mess]);
        },
        error => {
          console.log(error);
        });
    } else {
      console.log(this.formEdit);
    }
  }
}
