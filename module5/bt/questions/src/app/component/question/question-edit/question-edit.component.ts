import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {QuestionService} from "../../../service/question.service";
import {QuestionType} from "../../../model/question-type";

@Component({
  selector: 'app-question-edit',
  templateUrl: './question-edit.component.html',
  styleUrls: ['./question-edit.component.css']
})
export class QuestionEditComponent implements OnInit {
  formEdit: FormGroup;
  questionId: any;
  questionTypes: QuestionType[];


  constructor(private _formBuilder: FormBuilder,
              public  questionService: QuestionService,
              public router: Router,
              public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.questionService.getAllQuestionsTypes().subscribe(data => {
        this.questionTypes = data;
        console.log(this.questionTypes);
      }
    );
    this.formEdit = this._formBuilder.group({
      title: ['', [Validators.required]],
      question_type: ['', [Validators.required]],
      questionSentence: ['', [Validators.required]],
      answer: ['', [Validators.required]],
      dateCreate: ['', [Validators.required]],
      status: ['', [Validators.required]],
    });
    this.activatedRoute.params.subscribe(data => {
      this.questionId = data.id;
      this.questionService.findQuestionById(this.questionId).subscribe(data => {
        this.formEdit.patchValue(data);
        console.log(data);
      });
    });
  }

  compareFn(c1: QuestionType, c2: QuestionType): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    console.log(this.formEdit.value);
    console.log(this.formEdit.value.question_type);
    this.questionService.editCustomer(this.formEdit.value, this.questionId).subscribe(data => {
      alert('Edit question successfully');
      this.router.navigateByUrl('question/list');
    });
  }
}
