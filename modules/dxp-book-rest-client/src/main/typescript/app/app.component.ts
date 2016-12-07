import { Component, OnInit } from '@angular/core';

import { SamplesApi } from '../generated/index';
import { Book } from '../generated/model/book';

@Component({
    selector: 'app',
    templateUrl: '/o/dxpbookrestclient/templates/app.html'
})
export class AppComponent implements OnInit {
	errorMessage: string;
    books : Book[];

    constructor(public samplesService: SamplesApi) {
    }

    ngOnInit() {
        this.getAllItems();
        //console.log(this.books);
    }

    getAllItems() {
    	this.samplesService.getAllBook()
                     .subscribe(
                       book => this.books = book,
                       error =>  this.errorMessage = <any>error);
    }
}