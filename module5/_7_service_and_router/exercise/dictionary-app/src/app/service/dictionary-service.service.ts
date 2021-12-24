import { Injectable } from '@angular/core';
import {IWord} from "../model/iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {

  constructor() { }
  iWords: IWord[] = [{
    word: 'hello',
    mean: 'Xin chào',
  }, {
    word: 'table',
    mean: 'Bảng',
  }, {
    word: 'computer',
    mean: 'Máy tính',
  }];

  getAll() {
    return this.iWords;
  }

  getIWordByIndex(iWordIndex: number) {
    return this.iWords[iWordIndex];
  }
}
