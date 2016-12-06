import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { BookModule } from './book.module';

const platform = platformBrowserDynamic();

platform.bootstrapModule(BookModule);
