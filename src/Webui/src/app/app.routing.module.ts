import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// import {AppLayoutComponent} from "../_layout/app-layout/app-layout.component"
import {AppComponent} from "./app.component";


const routes: Routes = [
  {
    path: '', 
    // component: AppLayoutComponent, canActivate: [],
    // component: AppComponent,
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
      {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
      {path: 'issue', loadChildren: './pages/issue/issue.module#IssueModule'} ,
      {path: 'project', loadChildren: './pages/project/project.module#ProjectModule'},
      // {path: 'project/12/12', loadChildren: './pages/project/project.module#ProjectModule'}
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)] ,
  exports: [RouterModule]
})
export class AppRoutingModule { }
