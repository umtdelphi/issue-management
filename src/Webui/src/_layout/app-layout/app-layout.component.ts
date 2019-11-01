import {Component, OnInit} from "@angular/core";
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-app-layout',
  templateUrl: './app-layout.component.html',
  styleUrls: ['./app-layout.component.scss']
})
export class AppLayoutComponent implements OnInit {

  constructor(private translateService: TranslateService) {
    this.translateService.addLangs(['tr','de','en']);
    this.translateService.setDefaultLang('tr')
    
    const browserLang = this.translateService.getBrowserLang();
    this.translateService.use(browserLang.match(/tr|en|de/) ? browserLang : "en");
  }

  ngOnInit() {
  }

}