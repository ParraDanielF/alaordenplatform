import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminPaymentsComponent } from './admin-payments/admin-payments.component';

const routes: Routes = [
  {
    path: 'admin',
    component: AdminPaymentsComponent,
    pathMatch: 'full',
  },
  {
    path: '*',
    redirectTo: 'login',
    pathMatch: 'full',
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaymentsRoutingModule { }
