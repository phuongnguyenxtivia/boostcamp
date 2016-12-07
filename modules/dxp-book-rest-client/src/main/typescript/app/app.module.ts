import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { AppComponent }  from './app.component';
import { ViewBookComponent }  from './book/view/viewbook.component';
import { SamplesApi }    from '../generated/index';
import { routing }  from './app.routing';

@NgModule({
    imports:      [ BrowserModule, HttpModule, routing ],
    declarations: [ AppComponent, ViewBookComponent ],
    providers:    [ SamplesApi ],
    bootstrap:    [ AppComponent ]
})
 
export class AppModule {}