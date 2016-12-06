import { Component } from '@angular/core';
import { SamplesApi } from '../generated/index';

@Component({
    selector: 'index',
    templateUrl: '/o/dxpbookrestclient/templates/app.html'
})
export class AppComponent {
    book = {};

    constructor(public samples: SamplesApi) {
    }

    ngOnInit() {
        //this.samples.getAllBook().forEach(u => this.book = u);
        console.log(this.samples.getAllBook());
    }
}