import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import {HomeComponent} from "./component/home/home.component";
import { QuestionListComponent } from './component/question/question-list/question-list.component';
import { QuestionAddComponent } from './component/question/question-add/question-add.component';
import { QuestionDeleteComponent } from './component/question/question-delete/question-delete.component';
import { QuestionDetailComponent } from './component/question/question-detail/question-detail.component';
import { QuestionEditComponent } from './component/question/question-edit/question-edit.component';
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDialogModule} from "@angular/material/dialog";
import {CustomerDeleteComponent} from "../../../customer/src/app/component/customers/customer-delete/customer-delete.component";






@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    QuestionListComponent,
    QuestionAddComponent,
    QuestionDeleteComponent,
    QuestionDetailComponent,
    QuestionEditComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [CustomerDeleteComponent]
})
export class AppModule { }
