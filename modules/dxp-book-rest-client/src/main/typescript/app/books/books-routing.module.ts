import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookListComponent }    from './book-list.component';
import { BookDetailComponent }  from './book-detail.component';

const booksRoutes: Routes = [
  { path: 'books',  component: BookListComponent },
  { path: 'book/:isbn', component: BookDetailComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(booksRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class BooksRoutingModule { }