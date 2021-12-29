import {Component, Inject, OnInit} from '@angular/core';
import {BenhAn} from "../../../model/BenhAn";
import {Subscription} from "rxjs";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {BenhAnService} from "../../../service/benh-an.service";

@Component({
  selector: 'app-benh-an-delete',
  templateUrl: './benh-an-delete.component.html',
  styleUrls: ['./benh-an-delete.component.css']
})
export class BenhAnDeleteComponent implements OnInit {
  id: number;
  benhAn: BenhAn;
  private subscription: Subscription;

  constructor(
    private benhAnService: BenhAnService,
    public dialogRef: MatDialogRef<BenhAnDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.benhAnData.id);
    this.benhAn = this.data.benhAnData;
  }

  deleteBenhAn() {
    this.subscription = this.benhAnService.deleteBenhAn(this.benhAn.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
