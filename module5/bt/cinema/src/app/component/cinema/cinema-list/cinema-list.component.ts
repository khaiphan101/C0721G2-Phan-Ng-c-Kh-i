import {Component, OnInit} from '@angular/core';


import {MatDialog} from "@angular/material/dialog";
import {CinemaService} from "../../../service/cinema.service";
import {ShowCinema} from "../../../model/showCinema";
import {CinemaDeleteComponent} from "../cinema-delete/cinema-delete.component";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-cinema-list',
  templateUrl: './cinema-list.component.html',
  styleUrls: ['./cinema-list.component.css']
})
export class CinemaListComponent implements OnInit {
  public showCinemas: ShowCinema[];
  term: string;
  p: any;
  mess: string = '';

  constructor(
    public  cinemaService: CinemaService,
    public  activatedRoute: ActivatedRoute,
    public dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.cinemaService.getAllCustomers().subscribe(data => {
        this.showCinemas = data;
        console.log(this.showCinemas);
      }
    );
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.mess = paramMap.get('mess');
    });
  }

  // Mở dialog nhận id và trả về đối tượng customer
  openDialog(id): void {
    console.log(id);
    // Trả về đối tượng customer
    this.cinemaService.findById(id).subscribe(showCinemaData => {
      console.log(showCinemaData);
      const dialogRef = this.dialog.open(CinemaDeleteComponent, {
        width: '500px',
        data: {showCinemaData},
        // Khi bấm ra ngoài dialog khong bi mat di
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
