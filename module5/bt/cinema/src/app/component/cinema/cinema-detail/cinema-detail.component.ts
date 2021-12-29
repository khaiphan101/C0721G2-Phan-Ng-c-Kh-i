import { Component, OnInit } from '@angular/core';
import {ShowCinema} from "../../../model/showCinema";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CinemaService} from "../../../service/cinema.service";

@Component({
  selector: 'app-cinema-detail',
  templateUrl: './cinema-detail.component.html',
  styleUrls: ['./cinema-detail.component.css']
})
export class CinemaDetailComponent implements OnInit {
  showCinemaId: any;
  showCinema: ShowCinema;
  constructor(private _formBuilder: FormBuilder,
              public cinemaService: CinemaService,
              public activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(data => {
      this.showCinemaId = data.id;
      this.cinemaService.findById(this.showCinemaId).subscribe(data => {
        this.showCinema = data;
        console.log(this.showCinema);
      });
    });

  }
}
