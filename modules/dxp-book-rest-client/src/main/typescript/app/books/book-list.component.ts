import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { SamplesApi } from '../../generated/index';
import { Book } from '../../generated/model/book';

@Component({
    selector: 'book-list',
    templateUrl: '/o/dxpbookrestclient/books/book-list.component.html'
})
export class BookListComponent implements OnInit {
	errorMessage: string;
    books : Book[];
    //books: Observable<Book>;

    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.getAllBooks();
    }

    getAllBooks() {
    	this.sampleApi.getAllBook()
            .subscribe(
                books => this.books = books,
                error =>  this.errorMessage = <any>error);
    }

    deleteBook(book: Book) {
        this.sampleApi
            .deleteBook(book.isbn.toString())
            .subscribe(
                response => { console.log('success'); }, // NOTE: Success function never been called since deleteBook return nothing, only status
                error =>  this.errorMessage = <any>error);

        // TO-DO: it is dangerous, the following code should be put in a Success callback
        var index = this.books.indexOf(book);
        this.books.splice(index, 1);
    }

    onSelect(book: Book) {
        this.router.navigate(['/books/book', book.isbn ]);
    }

     goToBookAdd() {
        this.router.navigate(['/books/book-add']);
    }
}