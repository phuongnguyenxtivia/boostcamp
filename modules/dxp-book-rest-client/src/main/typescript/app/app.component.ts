import { Component } from '@angular/core';
import { SamplesApi } from '../generated/index';

@Component({
    selector: 'index',
    templateUrl: '/o/dxp-book-rest-client/templates/app.html'
})
export class AppComponent {
    user = {};

    constructor(public samples: SamplesApi) {
    }

    ngOnInit() {
        this.samples.getCurrentUser().forEach(u => this.user = u);
    }
}