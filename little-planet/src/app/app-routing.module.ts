import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';
import { HomeComponent } from './components/home/home.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { RewardsComponent } from './components/rewards/rewards.component';
import { TrackerComponent } from './components/tracker/tracker.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'goal-setting',component:GoalSettingComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'rewards',component:RewardsComponent},
  {path:'tracker',component:TrackerComponent},
  {path:'**',redirectTo:'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
