import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { SidebarComponent } from "../_layout/sidebar/sidebar.component ";
import { FooterComponent } from '../_layout/footer/footer.component ';
import { HeaderComponent } from '../_layout/header/header.component ';
import {ToastNoAnimation, ToastNoAnimationModule, ToastrModule} from "ngx-toastr";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import { ApiService } from './services/api.service';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import { ProjectService } from './services/shared/project.service';
import { IssueService } from './services/shared/issue.service';

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', 'tr.json');
}

@NgModule({
  declarations: [
    AppComponent ,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,    
    AppRoutingModule,
    NgxDatatableModule ,
    ToastNoAnimationModule,
    ToastrModule.forRoot({
      toastComponent: ToastNoAnimation,
      maxOpened: 1,
      autoDismiss: true
    }),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    })

  ],
  providers: [ApiService,ProjectService,IssueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
