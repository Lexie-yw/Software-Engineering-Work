import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-goal-content',
  templateUrl: './goal-content.component.html',
  styleUrls: ['./goal-content.component.css']
})
export class GoalContentComponent implements OnInit {

  public data:any=null;

  public goal_list:any[]=[
    {
      goal_num:1,
      goal_name:'brush teeth',
      click_num_completed:6,
      click_num_needed:10,
      description:'brush teeth 2 times each day'
    },
    {
      goal_num:2,
      goal_name:'jogging',
      click_num_completed:3,
      click_num_needed:40,
      description:'jogging outside at least 3 miles per day'
    },
    {
      goal_num:3,
      goal_name:'recite words',
      click_num_completed:0,
      click_num_needed:20,
      description:'recite 30 new English words before sleep'
    }
  ];

  click_on(){
    alert('click on successfully');
  }

  suspend() {
    alert('goal suspend');
  }

  constructor(public route:ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe((data)=>{
      this.data=data['aid'];
    })
  }

}
