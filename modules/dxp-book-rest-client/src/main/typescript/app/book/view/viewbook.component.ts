import { Component, OnInit } from '@angular/core';

import { SamplesApi } from '../../../generated/index';
import { Book } from '../../../generated/model/book';

@Component({
    selector: 'view-book',
    templateUrl: './book/view/viewbook.component.html'
})
export class ViewBookComponent implements OnInit {
	errorMessage: string;
    book : Book;

    constructor(public samplesService: SamplesApi) {
    }

    ngOnInit() {
        this.getItem();
        //console.log(this.books);
    }

    getItem() {
    	this.samplesService.getBook()
                     .subscribe(
                       item => this.book = item,
                       error =>  this.errorMessage = <any>error);
        return false;
    }
}