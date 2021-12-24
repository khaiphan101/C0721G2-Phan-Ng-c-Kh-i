import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {DictionaryServiceService} from "../service/dictionary-service.service";
import {IWord} from "../model/iword";

@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {
  iWordDetail: IWord | undefined;
  constructor(private _activateRoute: ActivatedRoute,
              private _dictionaryService: DictionaryServiceService
              ) { }

  ngOnInit(): void {
    let iWordIndex = this._activateRoute.snapshot.params['index'];
    this.iWordDetail = this._dictionaryService.getIWordByIndex(iWordIndex);
  }

}
