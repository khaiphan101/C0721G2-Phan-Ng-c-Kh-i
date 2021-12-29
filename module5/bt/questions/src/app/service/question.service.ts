import { Injectable } from '@angular/core';
import {Question} from "../model/question";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  public api_question: string = 'http://localhost:3000/questions';
  public api_question_type: string = 'http://localhost:3000/questionTypes';


  constructor(public http: HttpClient) {
  }

  getAllQuestions(): Observable<any> {
    return this.http.get(this.api_question);
  }

  getAllQuestionsTypes(): Observable<any> {
    return this.http.get(this.api_question_type);
  }

  addNewQuestion(question): Observable<any> {
    return this.http.post(this.api_question, question);
  }

  deleteQuestion(id: number): Observable<Question>  {
    return this.http.delete<Question>(this.api_question + '/' + id);
  }
  editCustomer(customer, customerId): Observable<any>  {
    return this.http.put(this.api_question + '/' + customerId, customer);
  }

  findQuestionById(id: any): Observable<Question>  {
    return this.http.get<Question>(this.api_question + '/' + id);
  }

}
