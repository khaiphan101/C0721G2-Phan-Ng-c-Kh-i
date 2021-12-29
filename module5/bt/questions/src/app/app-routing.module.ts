import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {HomeComponent} from "./component/home/home.component";
import {QuestionListComponent} from "./component/question/question-list/question-list.component";
import {QuestionAddComponent} from "./component/question/question-add/question-add.component";
import {QuestionDeleteComponent} from "./component/question/question-delete/question-delete.component";
import {QuestionEditComponent} from "./component/question/question-edit/question-edit.component";
import {QuestionDetailComponent} from "./component/question/question-detail/question-detail.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'question/list/:mess', component: QuestionListComponent},
  {path: 'question/add', component: QuestionAddComponent},
  {path: 'question/delete', component: QuestionDeleteComponent},
  {path: 'question/edit/:id', component: QuestionEditComponent},
  {path: 'question/detail/:id', component: QuestionDetailComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
