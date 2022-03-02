import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
login:string='';

loginSuccessFlag:boolean=false;
name:string='';
Flag:boolean=false
  constructor() { }

  ngOnInit(): void {
    let obj =sessionStorage.getItem("login");

    let obj1 =sessionStorage.getItem("user");
    let obj2=sessionStorage.getItem("signin");
    let obj3 =sessionStorage.getItem("adminLogin")
    let obj4=sessionStorage.getItem("adminSignin")
    let obj5 =sessionStorage.getItem("admin");
    if(obj!=null){
      this.login=obj;
      this.loginSuccessFlag=this.login.includes("Success");
      if(this.loginSuccessFlag ==true){
        if(obj1!=null){
       this.name= obj1
       sessionStorage.setItem("name",this.name)
       this.Flag=true
        }
      }
      
    }
    if(obj2!=null){
      this.login=obj2;
      this.loginSuccessFlag=this.login.includes("Success");
      if(this.loginSuccessFlag ==true){
        if(obj5!=null){
       this.name= obj5
       sessionStorage.setItem("name",this.name)
       this.Flag=true
        }
      }}
      if(obj3!=null){
        this.login=obj3;
        this.loginSuccessFlag=this.login.includes("Success");
        if(this.loginSuccessFlag ==true){
          if(obj5!=null){
         this.name= obj5
         sessionStorage.setItem("name",this.name)
         sessionStorage.setItem("adminFlag","1")
         this.Flag=true
          }
        }}
        if(obj4!=null){
          this.login=obj4;
          this.loginSuccessFlag=this.login.includes("Success");
          if(this.loginSuccessFlag ==true){
            if(obj5!=null){
           this.name= obj5
           sessionStorage.setItem("adminFlag","1")
           sessionStorage.setItem("name",this.name)
           this.Flag=true
            }
          }}
  }

}
