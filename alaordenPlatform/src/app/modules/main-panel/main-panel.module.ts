import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainPanelRoutingModule } from './main-panel-routing.module';
import { NewsFeedComponent } from './news-feed/news-feed.component';


@NgModule({
  declarations: [NewsFeedComponent],
  imports: [
    CommonModule,
    MainPanelRoutingModule
  ],
  exports: [NewsFeedComponent]
})
export class MainPanelModule { }
