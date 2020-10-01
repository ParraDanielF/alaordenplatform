import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PaymentsRoutingModule } from './payments-routing.module';
import { AdminPaymentsComponent } from './admin-payments/admin-payments.component';


@NgModule({
  declarations: [AdminPaymentsComponent],
  imports: [
    CommonModule,
    PaymentsRoutingModule
  ],
  exports: [AdminPaymentsComponent]
})
export class PaymentsModule { }
