import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewsFeedComponent } from './news-feed/news-feed.component';

const routes: Routes = [
  {
    path: 'main',
    component: NewsFeedComponent,
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
export class MainPanelRoutingModule { }
