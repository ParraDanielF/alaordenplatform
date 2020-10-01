import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DummieComponent } from './layouts/dummie/dummie.component';
import { PlatformLayoutComponent } from './layouts/platform-layout/platform-layout.component';
import { PublicLayoutComponent } from './layouts/public-layout/public-layout.component';

const routes: Routes = [
    /** main layout configuration */
    {
      path: '', component: PublicLayoutComponent,
      children: [
        {path: 'auth', loadChildren: () => import('./modules/authentication/authentication.module').then(m => m.AuthenticationModule)},
      ]
    },
    {
      path: 'playground',
      component: DummieComponent,
      pathMatch: 'full',
    },
    {
      path: 'platform', component: PlatformLayoutComponent,
      children: [
        {path: 'company', loadChildren: () => import('./modules/company/company.module').then(m => m.CompanyModule)},
        {path: 'contract', loadChildren: () => import('./modules/contract/contract.module').then(m => m.ContractModule)},
        {path: 'panel', loadChildren: () => import('./modules/main-panel/main-panel.module').then(m => m.MainPanelModule)},
        {path: 'payments', loadChildren: () => import('./modules/payments/payments.module').then(m => m.PaymentsModule)},
        {path: 'profile', loadChildren: () => import('./modules/profile/profile.module').then(m => m.ProfileModule)},
        {path: 'service', loadChildren: () => import('./modules/services/services.module').then(m => m.ServicesModule)}
      ]
    },
    {
      path: '',
      redirectTo: '/',
      pathMatch: 'full'
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
