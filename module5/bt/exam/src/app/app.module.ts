import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDialogModule} from "@angular/material/dialog";
import {HomeComponent} from "./component/home/home.component";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";

import { BenhAnListComponent } from './component/benh-an/benh-an-list/benh-an-list.component';
import { BenhAnAddComponent } from './component/benh-an/benh-an-add/benh-an-add.component';
import { BenhAnDetailComponent } from './component/benh-an/benh-an-detail/benh-an-detail.component';
import { BenhAnDeleteComponent } from './component/benh-an/benh-an-delete/benh-an-delete.component';
import { BenhAnEditComponent } from './component/benh-an/benh-an-edit/benh-an-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    BenhAnListComponent,
    BenhAnAddComponent,
    BenhAnDetailComponent,
    BenhAnDeleteComponent,
    BenhAnEditComponent,
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
  bootstrap: [AppComponent]
})
export class AppModule { }
