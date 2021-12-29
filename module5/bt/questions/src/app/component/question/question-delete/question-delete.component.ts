import {Component, Inject, OnInit} from '@angular/core';
import {Question} from "../../../model/question";
import {Subscription} from "rxjs";
import {QuestionService} from "../../../service/question.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-question-delete',
  templateUrl: './question-delete.component.html',
  styleUrls: ['./question-delete.component.css']
})
export class QuestionDeleteComponent implements OnInit {
  id: number;
  question: Question;
  private subscription: Subscription;

  constructor(
    private questionService: QuestionService,
    public dialogRef: MatDialogRef<QuestionDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    console.log(this.data.questionData.id);
    this.question = this.data.questionData;
  }

  deleteQuestion() {
    this.subscription = this.questionService.deleteQuestion(this.question.id).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
