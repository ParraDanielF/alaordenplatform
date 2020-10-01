import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServicesRoutingModule } from './services-routing.module';
import { ManageServicesComponent } from './manage-services/manage-services.component';


@NgModule({
  declarations: [ManageServicesComponent],
  imports: [
    CommonModule,
    ServicesRoutingModule
  ],
  exports: [ManageServicesComponent]
})
export class ServicesModule { }
