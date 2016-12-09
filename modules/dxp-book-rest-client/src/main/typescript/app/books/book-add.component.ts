import 'rxjs/add/operator/switchMap';

import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { SamplesApi } from '../../generated/index';
import { Book } from '../../generated/model/book';

@Component({
    selector: 'book-add',
    templateUrl: '/o/dxpbookrestclient/books/book-add.component.html'
})
export class BookAddComponent implements OnInit {
	errorMessage: string;
    book : Book;

    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.book = {};
    }   

    addBook() {
        this.sampleApi.addBook(this.book)
            .subscribe(
                (book: Book) => { 
                    // reset for new book
                    this.book = {};
                }, 
                error =>  this.errorMessage = <any>error);
    }

    goToBookList() {
        this.router.navigate(['/books']);
    }
}