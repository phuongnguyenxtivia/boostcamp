import { NgModule }       from '@angular/core';
import { CommonModule }   from '@angular/common';
import { FormsModule }    from '@angular/forms';

import { SamplesApi } from '../../generated/index';
import { BookListComponent }    from './book-list.component';
import { BookDetailComponent }  from './book-detail.component';
import { BooksRoutingModule } from './books-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    BooksRoutingModule
  ],
  declarations: [
    BookListComponent,
    BookDetailComponent
  ],
  providers: [
    SamplesApi
  ]
})
export class BooksModule {}