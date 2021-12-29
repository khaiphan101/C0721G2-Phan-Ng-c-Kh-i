import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CinemaService {
  public apiShowCinema: string = 'http://localhost:3000/showCinemas';
  public apiMovie: string = 'http://localhost:3000/movies';

  constructor(public http: HttpClient) {
  }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.apiShowCinema);
  }

  getAllMovies(): Observable<any> {
    return this.http.get(this.apiMovie);
  }

  addNew(obj): Observable<any> {
    return this.http.post(this.apiShowCinema, obj);
  }

  findById(id: any): Observable<any>  {
    return this.http.get<any>(this.apiShowCinema + '/' + id);
  }

  delete(id: number): Observable<any>  {
    return this.http.delete<any>(this.apiShowCinema + '/' + id);
  }
  edit(obj, id): Observable<any>  {
    return this.http.put(this.apiShowCinema + '/' + id, obj);
  }
}
