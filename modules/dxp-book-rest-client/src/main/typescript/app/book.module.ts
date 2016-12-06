import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { AppComponent }  from './app.component';
import { RouterModule }  from '@angular/router';
import { SamplesApi }    from '../generated/index';

@NgModule({
    imports:      [ BrowserModule, HttpModule ],
    declarations: [ AppComponent ],
    providers:    [ SamplesApi ],
    bootstrap:    [ AppComponent ]
})

export class BookModule { }