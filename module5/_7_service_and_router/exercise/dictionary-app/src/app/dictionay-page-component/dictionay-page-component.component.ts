import { Component, OnInit } from '@angular/core';
import {IWord} from "../model/iword";
import {DictionaryServiceService} from "../service/dictionary-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  iwords: IWord[] = [];
  constructor(private _dictionaryService: DictionaryServiceService,
              private _router: Router) {

  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.iwords = this._dictionaryService.getAll();
  }
  showDetail(index: number){
    this._router.navigate(['detail', index]);
  }
}
