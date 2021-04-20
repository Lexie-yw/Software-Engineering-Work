import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test1',
  templateUrl: './test1.component.html',
  styleUrls: ['./test1.component.css']
})
export class Test1Component implements OnInit {

  public list:any[]=[];

  constructor() { }

  ngOnInit(): void {
    for (var i=0;i<10;i++){
      this.list.push('goal'+i);
    }
  }

}
