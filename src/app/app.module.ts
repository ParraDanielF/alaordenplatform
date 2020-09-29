import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PublicLayoutComponent } from './layouts/public-layout/public-layout.component';
import { PlatformLayoutComponent } from './layouts/platform-layout/platform-layout.component';
import { DummieComponent } from './layouts/dummie/dummie.component';
import { HeaderModule } from './components/header/header.module';
import { FooterModule } from './components/footer/footer.module';
import { SidemenuModule } from './components/sidemenu/sidemenu.module';

@NgModule({
  declarations: [
    AppComponent,
    PublicLayoutComponent,
    PlatformLayoutComponent,
    DummieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    FooterModule,
    SidemenuModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [PublicLayoutComponent, PlatformLayoutComponent, DummieComponent]
})
export class AppModule { }
