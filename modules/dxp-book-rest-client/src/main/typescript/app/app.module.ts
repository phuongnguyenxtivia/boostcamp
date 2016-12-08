import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { SamplesApi }    from '../generated/index';
import { AppComponent }  from './app.component';
import { AppRoutingModule }     from './app-routing.module';
import { BooksModule }  from './books/books.module';

@NgModule({
    imports:      [ BrowserModule, HttpModule, AppRoutingModule, BooksModule ],
    declarations: [ AppComponent  ],
    providers:    [ SamplesApi ],
    bootstrap:    [ AppComponent ]
})
 
export class AppModule {}