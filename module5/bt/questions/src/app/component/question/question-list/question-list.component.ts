import { Component, OnInit } from '@angular/core';

import {MatDialog} from "@angular/material/dialog";
import {Question} from "../../../model/question";
import {QuestionService} from "../../../service/question.service";
import {QuestionDeleteComponent} from "../question-delete/question-delete.component";


@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {
  public questions: Question[];
  term: string;
  p: any;


  constructor(
    public  questionService: QuestionService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.questionService.getAllQuestions().subscribe(data => {
        this.questions = data;
        console.log(this.questions);
      }
    );
  }

  // Mở dialog nhận id và trả về đối tượng customer
  openDialog(id): void {
    console.log(id);
    // Trả về đối tượng customer
    this.questionService.findQuestionById(id).subscribe(questionData => {
      console.log(questionData);
      const dialogRef = this.dialog.open(QuestionDeleteComponent, {
        // width: '500px',
        data: {questionData},
        // Khi bấm ra ngoài dialog khong bi mat di
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
