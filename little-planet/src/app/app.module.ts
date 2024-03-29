import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClientJsonpModule } from '@angular/common/http';
import { RouterModule} from "@angular/router";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { TrackerComponent } from './components/tracker/tracker.component';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';
import { RewardsComponent } from './components/rewards/rewards.component';

import { CommonService } from './services/common.service';
import { GoalContentComponent } from './components/goal-content/goal-content.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    TrackerComponent,
    GoalSettingComponent,
    RewardsComponent,
    GoalContentComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientJsonpModule,
    RouterModule
  ],
  providers: [CommonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
