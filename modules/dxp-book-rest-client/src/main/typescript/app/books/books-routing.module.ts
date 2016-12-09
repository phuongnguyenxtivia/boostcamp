import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookListComponent }    from './book-list.component';
import { BookDetailComponent }  from './book-detail.component';
import { BookAddComponent }  from './book-add.component';
import { BookEditComponent }  from './book-edit.component';

const booksRoutes: Routes = [
  { path: 'books',	  component: BookListComponent },
  { path: 'books/book/:isbn', component: BookDetailComponent },
  { path: 'books/book-add', component: BookAddComponent },
  { path: 'books/book-edit/:isbn', component: BookEditComponent }
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