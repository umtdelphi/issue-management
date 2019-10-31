import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';



@NgModule({
  exports : [TranslateModule] ,
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
