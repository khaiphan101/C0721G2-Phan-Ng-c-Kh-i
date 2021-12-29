import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {BenhAnListComponent} from "./component/benh-an/benh-an-list/benh-an-list.component";
import {BenhAnAddComponent} from "./component/benh-an/benh-an-add/benh-an-add.component";
import {BenhAnDeleteComponent} from "./component/benh-an/benh-an-delete/benh-an-delete.component";
import {BenhAnEditComponent} from "./component/benh-an/benh-an-edit/benh-an-edit.component";
import {BenhAnDetailComponent} from "./component/benh-an/benh-an-detail/benh-an-detail.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'benh-an/list/:mess', component: BenhAnListComponent},
  {path: 'benh-an/add', component: BenhAnAddComponent},
  {path: 'benh-an/delete', component: BenhAnDeleteComponent},
  {path: 'benh-an/edit/:id', component: BenhAnEditComponent},
  {path: 'benh-an/detail/:id', component: BenhAnDetailComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
