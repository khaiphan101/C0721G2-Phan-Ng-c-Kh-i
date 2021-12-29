import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {CinemaAddComponent} from "./component/cinema/cinema-add/cinema-add.component";
import {CinemaDeleteComponent} from "./component/cinema/cinema-delete/cinema-delete.component";
import {CinemaEditComponent} from "./component/cinema/cinema-edit/cinema-edit.component";
import {CinemaDetailComponent} from "./component/cinema/cinema-detail/cinema-detail.component";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";
import {CinemaListComponent} from "./component/cinema/cinema-list/cinema-list.component";



const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'cinema/list/:mess', component: CinemaListComponent},
  {path: 'cinema/add', component: CinemaAddComponent},
  {path: 'cinema/delete', component: CinemaDeleteComponent},
  {path: 'cinema/edit/:id', component: CinemaEditComponent},
  {path: 'cinema/detail/:id', component: CinemaDetailComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
