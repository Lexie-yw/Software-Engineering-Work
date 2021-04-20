import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rewards',
  templateUrl: './rewards.component.html',
  styleUrls: ['./rewards.component.css']
})
export class RewardsComponent implements OnInit {

  public flag: boolean = true;

  public picUrl ="https://images.unsplash.com/photo-1454537468202-b7ff71d51c2e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2849&q=80";

  public picStatus: number = 1; /* 1. goal created 2. goal finished 3. goal suspended */
  constructor() { }

  ngOnInit(): void {
  }

}
