import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompanyRoutingModule } from './company-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [ProfileComponent, RegisterComponent],
  imports: [
    CommonModule,
    CompanyRoutingModule
  ],
  exports: [ProfileComponent, RegisterComponent]
})
export class CompanyModule { }
