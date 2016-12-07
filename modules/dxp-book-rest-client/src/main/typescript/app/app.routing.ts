import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component'; 						//import list of books components
import { ViewBookComponent } from './book/view/viewbook.component'; 	//import view book detail component

const appRoutes: Routes = [
  { path: 'app', component: AppComponent },
  { path: 'viewbook/:isbn', component: ViewBookComponent },
  { path: '', component: AppComponent, pathMatch: 'full'} 				// redirect to home page on load
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);