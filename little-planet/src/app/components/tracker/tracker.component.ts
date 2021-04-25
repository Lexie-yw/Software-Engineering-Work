import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tracker',
  templateUrl: './tracker.component.html',
  styleUrls: ['./tracker.component.css']
})
export class TrackerComponent implements OnInit {

  public title = "this is a progress tracker";

  public goal_list:any[]=[
    {
      goal_num:0,
      goal_name:'name 0',
    },
    {
      goal_num:1,
      goal_name:'name 1',
    },
    {
      goal_num:2,
      goal_name:'name 2',
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
