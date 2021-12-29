import { Component, OnInit } from '@angular/core';
import {BenhAn} from "../../../model/BenhAn";
import {MatDialog} from "@angular/material/dialog";
import {BenhAnService} from "../../../service/benh-an.service";
import {BenhAnDeleteComponent} from "../benh-an-delete/benh-an-delete.component";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-benh-an-list',
  templateUrl: './benh-an-list.component.html',
  styleUrls: ['./benh-an-list.component.css']
})
export class BenhAnListComponent implements OnInit {
  public benhAns: BenhAn[];
  term: string;
  p: any;
  mess: string;

  constructor(
    public  benhAnService: BenhAnService,
    public dialog: MatDialog,
    public activatedRoute: ActivatedRoute,

  ) {
  }

  ngOnInit(): void {
    this.benhAnService.getAllBenhAn().subscribe(data => {
        this.benhAns = data;
        console.log(this.benhAns);
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
    this.benhAnService.findById(id).subscribe(benhAnData => {
      console.log(benhAnData);
      const dialogRef = this.dialog.open(BenhAnDeleteComponent, {
        // width: '500px',
        data: {benhAnData},
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
