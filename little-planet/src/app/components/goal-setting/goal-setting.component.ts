import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-goal-setting',
  templateUrl: './goal-setting.component.html',
  styleUrls: ['./goal-setting.component.css']
})
export class GoalSettingComponent implements OnInit {

  // public startDay: any = new Date();

  public goal:any={
      goal_name:null,
      clicks_num_needed:null,
      description:null
    };


  constructor(public router:Router) {
    // console.log(this.startDay);
  }

  ngOnInit(): void {
    this.goal.goal_name='12345';

  }

  refresh(){
    this.goal.goal_name=null;
    this.goal.clicks_num_needed=null;
    this.goal.description=null;
  }

  // doSubmit() {
  //   // let goalnameDom: any = document.getElementById("goal_name");
  //   // console.log(goalnameDom.value);

  // }

}
