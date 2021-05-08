import { Component, OnInit } from '@angular/core';
import { CommonService } from '../../services/common.service';


@Component({
  selector: 'app-tracker',
  templateUrl: './tracker.component.html',
  styleUrls: ['./tracker.component.css']
})
export class TrackerComponent implements OnInit {

  public title = "this is a progress tracker";

  public list:any[]=[];

  public goal_list:any[]=[
    {
      goal_num:1,
      goal_name:'brush teeth',
    },
    {
      goal_num:2,
      goal_name:'jogging',
    },
    {
      goal_num:3,
      goal_name:'recite words',
    }
  ];

  constructor(public common:CommonService) { }

  ngOnInit(): void {
    var api = 'goal/get/2';
    this.common.get(api).then((response:any)=>{
      console.log(response);
      this.list=response.result;
    })
  }

}
