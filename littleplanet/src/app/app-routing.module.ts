import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Test1Component } from './components/test1/test1.component';
import { Test2Component } from './components/test2/test2.component';
import { Test3Component } from './components/test3/test3.component';
import { TestHomeComponent } from './components/components/test-home/test-home.component';

const routes: Routes = [
  {path:'home',component:TestHomeComponent},
  {path:'test1',component:Test1Component},
  {path:'test2/:pid',component:Test2Component},
  {path:'test3/:aid',component:Test3Component},
  {path:'**',redirectTo:'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
