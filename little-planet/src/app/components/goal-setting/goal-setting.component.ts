import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-goal-setting',
  templateUrl: './goal-setting.component.html',
  styleUrls: ['./goal-setting.component.css']
})
export class GoalSettingComponent implements OnInit {

  // public startDay: any = new Date();

  public goal:any={
      goalName:null,
      totalTimes:null,
      description:null
    };


  constructor(public router:Router,public http:HttpClient) {
    // console.log(this.startDay);
  }

  ngOnInit(): void {

  }

  refresh(){
    this.goal.goalName=null;
    this.goal.totalTimes=null;
    this.goal.description=null;
  }

  confirm() {
    const httpOptions = { headers: new HttpHeaders({'ContentType':'application/json'})};
    var api = 'http://localhost:8081/goal/add';
    this.http.post(api,{"userId":"","goalName":"test1","description":"test","startTime":"2020-04-27","endTime":"2020-04-27"},httpOptions).
    subscribe((response)=>{
      console.log(response);
    })
  }

  // doSubmit() {
  //   // let goalnameDom: any = document.getElementById("goal_name");
  //   // console.log(goalnameDom.value);

  // }

}
