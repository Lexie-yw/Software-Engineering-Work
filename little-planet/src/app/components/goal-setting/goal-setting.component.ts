import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-goal-setting',
  templateUrl: './goal-setting.component.html',
  styleUrls: ['./goal-setting.component.css']
})
export class GoalSettingComponent implements OnInit {

  // public startDay: any = new Date();


  constructor() { 
    // console.log(this.startDay);
  }

  ngOnInit(): void {
  }

  // doSubmit() {
  //   // let goalnameDom: any = document.getElementById("goal_name");
  //   // console.log(goalnameDom.value); 

  // } 

}
