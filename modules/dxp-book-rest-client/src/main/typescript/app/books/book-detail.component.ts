import 'rxjs/add/operator/switchMap';

import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { SamplesApi } from '../../generated/index';
import { Book } from '../../generated/model/book';

@Component({
    selector: 'book-detail',
    templateUrl: '/o/dxpbookrestclient/books/book-detail.component.html'
})
export class BookDetailComponent implements OnInit {
	errorMessage: string;
    book : Book;

    // constructor(public samplesService: SamplesApi) {
    // }

    // ngOnInit() {
    //     this.getItem();
    //     //console.log(this.books);
    // }

    // getItem() {
    // 	this.samplesService.getBook()
    //                  .subscribe(
    //                    item => this.book = item,
    //                    error =>  this.errorMessage = <any>error);
    //     return false;
    // }
    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.getBook();
    }

    getBook() {
        // (+) converts string 'id' to a number
        this.book = this.route.params
            .switchMap((params: Params) => this.sampleApi.getBook(params['isbn']))
            .subscribe((book: Book) => this.book = book);
    }

    goToBookList() {
        this.router.navigate(['/books']);
    }

    goToBookEdit(isbn: string) {
        this.router.navigate(['/books/book-edit', isbn ]);
    }
}