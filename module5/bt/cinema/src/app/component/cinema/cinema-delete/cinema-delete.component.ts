import {Component, Inject, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CinemaService} from "../../../service/cinema.service";
import {ShowCinema} from "../../../model/showCinema";

@Component({
  selector: 'app-cinema-delete',
  templateUrl: './cinema-delete.component.html',
  styleUrls: ['./cinema-delete.component.css']
})
export class CinemaDeleteComponent implements OnInit {
  id: number;
  showCinema: ShowCinema;
  private subscription: Subscription;

  constructor(
    private cinemaService: CinemaService,
    public dialogRef: MatDialogRef<CinemaDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.showCinemaData.id);
    this.showCinema = this.data.showCinemaData;
  }

  deleteShowCinema() {
    this.subscription = this.cinemaService.delete(this.showCinema.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
