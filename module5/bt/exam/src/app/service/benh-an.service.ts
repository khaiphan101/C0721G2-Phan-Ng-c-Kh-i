import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenhAn} from "../model/BenhAn";

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {
  public apiBenhAns: string = 'http://localhost:3000/benhAns';


  constructor(public http: HttpClient) {
  }

  getAllBenhAn(): Observable<any> {
    return this.http.get(this.apiBenhAns);
  }

  addNewQuestion(question): Observable<any> {
    return this.http.post(this.apiBenhAns, question);
  }

  deleteBenhAn(id: number): Observable<BenhAn>  {
    return this.http.delete<BenhAn>(this.apiBenhAns + '/' + id);
  }
  editBenhAn(benhAn, customerId): Observable<any>  {
    return this.http.put(this.apiBenhAns + '/' + customerId, benhAn);
  }

  findById(id: any): Observable<BenhAn>  {
    return this.http.get<BenhAn>(this.apiBenhAns + '/' + id);
  }

}
