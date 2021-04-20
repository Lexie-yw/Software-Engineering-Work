import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-test1',
  templateUrl: './test1.component.html',
  styleUrls: ['./test1.component.css']
})
export class Test1Component implements OnInit {

  public list:any[]=[];

  constructor(public router:Router) { }

  ngOnInit(): void {
    for (var i=0;i<10;i++){
      this.list.push('goal'+i);
    }
  }

  gotest3(){
    this.router.navigate(['/test3/',123445]);
  }

}
