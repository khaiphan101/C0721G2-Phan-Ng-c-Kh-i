import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { CinemaListComponent } from './component/cinema/cinema-list/cinema-list.component';
import { CinemaAddComponent } from './component/cinema/cinema-add/cinema-add.component';
import { CinemaDeleteComponent } from './component/cinema/cinema-delete/cinema-delete.component';
import { CinemaDetailComponent } from './component/cinema/cinema-detail/cinema-detail.component';
import { CinemaEditComponent } from './component/cinema/cinema-edit/cinema-edit.component';
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDialogModule} from "@angular/material/dialog";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    CinemaListComponent,
    CinemaAddComponent,
    CinemaDeleteComponent,
    CinemaDetailComponent,
    CinemaEditComponent
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
