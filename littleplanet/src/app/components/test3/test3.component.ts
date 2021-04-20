import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-test3',
  templateUrl: './test3.component.html',
  styleUrls: ['./test3.component.css']
})
export class Test3Component implements OnInit {



  constructor(public route:ActivatedRoute) { }

  ngOnInit(): void {

    this.route.params.subscribe((data)=>{
      console.log(data);

    })
  }

}
