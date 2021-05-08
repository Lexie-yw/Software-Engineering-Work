import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  public domain:string='http://localhost:8081/';

  constructor(public http:HttpClient) { }

  get(api:any){
    return new Promise((resolve,reject)=>{

      this.http.get(this.domain +api ).subscribe((response)=>{

        resolve(response);
      })
    })
  }
}
