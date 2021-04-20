import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public picUrl = "little-planet/src/assets/images/elena-mozhvilo-planet-unsplash.jpg";

  public list: any[] = [
    {
      "title": "this is item1"

    },
    {
      "title": "this is item2"

    },
    {
      "title": "this is item3"

    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
