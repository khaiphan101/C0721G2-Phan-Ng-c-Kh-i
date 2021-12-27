import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {EmployeeListComponent} from "./components/employees/employee-list/employee-list.component";
import {EmployeeAddComponent} from "./components/employees/employee-add/employee-add.component";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";




const routes: Routes = [
  {path: '',component: HomeComponent},
  {path: 'employee/list',component: EmployeeListComponent},
  {path: 'employee/add',component: EmployeeAddComponent},
  {path: '**',component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes), MatDatepickerModule,
    MatNativeDateModule  ],
  exports: [RouterModule],
  // declarations: [HomeComponent]
})
export class AppRoutingModule { }
