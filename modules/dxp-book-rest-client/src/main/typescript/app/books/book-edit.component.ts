import 'rxjs/add/operator/switchMap';

import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { SamplesApi } from '../../generated/index';
import { Book } from '../../generated/model/book';

@Component({
    selector: 'book-edit',
    templateUrl: '/o/dxpbookrestclient/books/book-edit.component.html'
})
export class BookEditComponent implements OnInit {
	errorMessage: string;
    book : Book;

    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.getBook();
    }

    getBook() {
        this.book = this.route.params
            .switchMap((params: Params) => this.sampleApi.getBook(params['isbn']))
            .subscribe((book: Book) => this.book = book);
    }    

    updateBook() {
        this.sampleApi
            .updateBook(this.book.isbn.toString(), this.book)
            .subscribe(
                (book: Book) => { 
                    this.book = book;

                   // go to book detail page (as LR01-DEV exercise)
                   this.goToBookDetail(this.book.isbn.toString());
                }, 
                error =>  this.errorMessage = <any>error);
    }

    goToBookDetail(isbn: string) {
        this.router.navigate(['/books/book', isbn]);
    }
}