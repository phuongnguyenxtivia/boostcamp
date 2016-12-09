import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { FormsModule } from '@angular/forms';

import { SamplesApi }    from '../generated/index';
import { AppComponent }  from './app.component';
import { AppRoutingModule }     from './app-routing.module';
import { BooksModule }  from './books/books.module';
import { BookAddComponent }  from './books/book-add.component';
import { BookEditComponent }  from './books/book-edit.component';

@NgModule({
    imports:      [ BrowserModule, HttpModule, FormsModule, AppRoutingModule, BooksModule ],
    declarations: [ AppComponent, BookAddComponent, BookEditComponent ],
    providers:    [ SamplesApi ],
    bootstrap:    [ AppComponent ]
})
 
export class AppModule {}