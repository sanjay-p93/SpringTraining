import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { BooksComponent } from './books/books.component';
import { ErrorComponent } from './error/error.component';
import { GenreComponent } from './genre/genre.component';

const routes: Routes = 
[
  {path:"",redirectTo:"/home",pathMatch:"full"},
  {path:'home',component: BooksComponent},
  {path:'add',component: AddBookComponent},
  {path:'genre',component: GenreComponent},
  {path:'error',component:ErrorComponent},
  {path:'**',redirectTo:"/error",pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
