import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  public rTitle: string = "Welcome to Little Planet";
  public userInfo: any;
  public passWd: any = "This is your passward.";
  public email: any = "This is your email";
  public keywords: string = " This is the default value";

  public list:any = {
    userName : null,
    email : null,
    password : null
  };


  constructor(public http:HttpClient) { }

  ngOnInit(): void {

  }

  login() {
    const httpOptions = { headers: new HttpHeaders({'ContentType':'application/json'})};
    var api = 'http://localhost:8081/user/login';
    this.http.post(api,this.list,httpOptions).
    subscribe((response)=>{
      console.log(response);
    })
  }

  create_account() {
    //alert('A new account has been created');
    const httpOptions = { headers: new HttpHeaders({'ContentType':'application/json'})};
    var api = 'http://localhost:8081/user/register';
    this.http.post(api,this.list,httpOptions).
    subscribe((response)=>{
      console.log(response);
    })
  }

  find_password() {
    alert('password has been sent to your email');
  }

  getData() {
    alert(this.email);
    alert(this.passWd);
  }

  setData() {
    this.passWd = "A new password has been set!";
    this.email = "A new email has been set!";
  }

  runEvent(event:any) {
    let dom:any = event.target;

    dom.style.color = "purple";

  }

  keyDown(e:any) {
    if (e.keyCode == 13) {
      console.log('return keyDown');
    } else {
      // 获取当前对象及值
      console.log(e.target.value);
    }

  }

  keyUp(e:any) {
    if (e.keyCode == 13) {
      console.log('return keyUp');
    } else {
      // 获取当前对象及值
      console.log(e.target.value);
    }
  }

  changeKeywords() {
    this.keywords = "this is the updated value of keywords"
  }

  getKeywords() {
    console.log(this.keywords)
  }

}
