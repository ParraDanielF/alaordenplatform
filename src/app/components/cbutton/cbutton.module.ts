import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CbuttonComponent } from './cbutton.component';



@NgModule({
  declarations: [CbuttonComponent],
  imports: [
    CommonModule
  ],
  exports: [CbuttonComponent]
})
export class CbuttonModule { }
