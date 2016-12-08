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
    // books : Book[];
    books: Observable<Book>;

    // constructor(public samplesService: SamplesApi) {
    // }
    constructor(
        private sampleApi: SamplesApi,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.getAllBooks();
        //console.log(this.books);
    }

    getAllBooks() {
    	// this.samplesService.getAllBook()
     //                 .subscribe(
     //                   book => this.books = book,
     //                   error =>  this.errorMessage = <any>error);
         this.books = this.sampleApi.getAllBook();
    }

    onSelect(book: Book) {
        this.router.navigate(['/book', book.isbn ]);
    }
}