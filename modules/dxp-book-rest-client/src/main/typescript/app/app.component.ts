import { Component, OnInit } from '@angular/core';

import { SamplesApi } from '../generated/index';
import { Book } from '../generated/model/book';

@Component({
    selector: 'app',
    template: `
        <h1 class="title">Angular 2 SPA (Router)</h1>
        <router-outlet></router-outlet>
    `
})
export class AppComponent implements OnInit {
	errorMessage: string;
    books : Book[];

    constructor(public samplesService: SamplesApi) {
    }

    ngOnInit() {
        this.getAllItems();
    }

    getAllItems() {
    	this.samplesService.getAllBook()
            .subscribe(
                book => this.books = book,
                error =>  this.errorMessage = <any>error);
    }
}