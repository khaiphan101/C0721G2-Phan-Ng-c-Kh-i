import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {HomeComponent} from './component/home/home.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {CustomerAddComponent} from './component/customers/customer-add/customer-add.component';
import {CustomerListComponent} from './component/customers/customer-list/customer-list.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomerDeleteComponent} from './component/customers/customer-delete/customer-delete.component';
import {MatDialogModule} from '@angular/material/dialog';
import { CustomerEditComponent } from './component/customers/customer-edit/customer-edit.component';
import { CustomerDetailComponent } from './component/customers/customer-detail/customer-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    CustomerAddComponent,
    CustomerListComponent,
    CustomerDeleteComponent,
    CustomerEditComponent,
    CustomerDetailComponent,
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
export class AppModule {
}
