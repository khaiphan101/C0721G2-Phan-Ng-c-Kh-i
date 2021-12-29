import {Component, OnInit} from '@angular/core';
import {QuestionType} from "../../../../../../questions/src/app/model/question-type";
import {QuestionService} from "../../../../../../questions/src/app/service/question.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BenhAnService} from "../../../service/benh-an.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-benh-an-edit',
  templateUrl: './benh-an-edit.component.html',
  styleUrls: ['./benh-an-edit.component.css']
})
export class BenhAnEditComponent implements OnInit {
  formEdit: FormGroup;
  benhAnId: any;

  constructor(private _formBuilder: FormBuilder,
              public  benhAnService: BenhAnService,
              public router: Router,
              public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formEdit = this._formBuilder.group({
      id: [''],
      maBenhAn: [''],
      maBenhNhan: [''],
      ngayNhapVien: ['', [Validators.required]],
      ngayRaVien: ['', [Validators.required]],
      lyDo: ['', [Validators.required]],
      phuongPhap: ['', [Validators.required]],
      BacSiDieuTri: ['', [Validators.required]],
      ten: ['', [Validators.required, Validators.pattern('^([^0-9]*)$')]],
    });
    this.activatedRoute.params.subscribe(data => {
      this.benhAnId = data.id;
      this.benhAnService.findById(this.benhAnId).subscribe(data => {
        this.formEdit.patchValue(data);
        console.log(data);
      });
    });
  }

  onSubmit() {
    // console.log(this.formEdit.value);
    // this.benhAnService.editBenhAn(this.formEdit.value, this.benhAnId).subscribe(data => {
    //   alert('Edit question successfully');
    //   this.router.navigateByUrl('benh-an/list');
    // });

    console.log(this.formEdit.value);
    console.log(this.formEdit.value.movie);
    if (this.formEdit.valid) {
      const mess = 'Chỉnh sửa bệnh án thành công!';
      this.benhAnService.editBenhAn(this.formEdit.value, this.benhAnId).subscribe(value => {
          this.router.navigate(['benh-an/list', mess]);
        },
        error => {
          console.log(error);
        });
    } else {
      console.log(this.formEdit);
    }
  }
}
