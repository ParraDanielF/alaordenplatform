import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthenticationRoutingModule } from './authentication-routing.module';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { RecoverComponent } from './recover/recover.component';
import { NewCredentialsComponent } from './new-credentials/new-credentials.component';


@NgModule({
  declarations: [RegisterComponent, LoginComponent, RecoverComponent, NewCredentialsComponent],
  imports: [
    CommonModule,
    AuthenticationRoutingModule
  ],
  exports: [RegisterComponent, LoginComponent, RecoverComponent, NewCredentialsComponent]
})
export class AuthenticationModule { }
