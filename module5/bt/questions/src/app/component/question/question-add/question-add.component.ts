import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuestionType} from "../../../model/question-type";
import {Router} from "@angular/router";
import {QuestionService} from "../../../service/question.service";

@Component({
  selector: 'app-question-add',
  templateUrl: './question-add.component.html',
  styleUrls: ['./question-add.component.css']
})
export class QuestionAddComponent implements OnInit {

  formCreate: FormGroup;

  questionTypes: QuestionType[];

  constructor(private _formBuilder: FormBuilder,
              public  questionService: QuestionService,
              public router: Router) { }

  ngOnInit(): void {
    this.questionService.getAllQuestionsTypes().subscribe(data => {
        this.questionTypes = data;
        console.log(this.questionTypes);
      }
    );
    this.formCreate = this._formBuilder.group({
      title: ['', [Validators.required]],
      question_type: ['', [Validators.required]],
      questionSentence: ['', [Validators.required]],
      answer: ['', [Validators.required]],
      dateCreate: ['', [Validators.required]],
      status: ['', [Validators.required]],
    });
  }

  onSubmit() {
    console.log(this.formCreate.value);
    this.questionService.addNewQuestion(this.formCreate.value).subscribe(data =>{
      this.router.navigateByUrl('question/list');
    });
  }

}
