import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from "./component/customers/customer-list/customer-list.component";
import {CustomerAddComponent} from "./component/customers/customer-add/customer-add.component";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {HomeComponent} from "./component/home/home.component";
import {CustomerDeleteComponent} from "./component/customers/customer-delete/customer-delete.component";
import {CustomerEditComponent} from "./component/customers/customer-edit/customer-edit.component";
import {CustomerDetailComponent} from "./component/customers/customer-detail/customer-detail.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer/list', component: CustomerListComponent},
  {path: 'customer/add', component: CustomerAddComponent},
  {path: 'customer/delete', component: CustomerDeleteComponent},
  {path: 'customer/edit/:id', component: CustomerEditComponent},
  {path: 'customer/detail/:id', component: CustomerDetailComponent},
  {path: '**', component: PageNotFoundComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
