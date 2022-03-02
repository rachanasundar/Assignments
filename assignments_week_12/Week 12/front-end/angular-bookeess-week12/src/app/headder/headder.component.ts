import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-headder',
  templateUrl: './headder.component.html',
  styleUrls: ['./headder.component.css']
})
export class HeadderComponent implements OnInit {

  constructor(
    public router:Router
  ) { }

 adminFlag:boolean=false;
  flag:boolean=false
  ngOnInit(): void {

   let obj1 =sessionStorage.getItem("name");
   let obj2 =sessionStorage.getItem("adminFlag")
   if(obj1!=null){
     this.flag=true
     if(obj2!=null&& obj2 == "1"){
        this.adminFlag=true
     }
      }
  }
  logOut(){
    sessionStorage.removeItem("name")
    sessionStorage.removeItem("login")
    sessionStorage.removeItem("signin")
    sessionStorage.removeItem("user")
    sessionStorage.removeItem("adminLogin")
    sessionStorage.removeItem("adminSignin")
    sessionStorage.removeItem("admin")
    sessionStorage.setItem("logout","You Have Logged Out. Vist Again")
    this.flag=false
    this.router.navigate(["home"]);
   
  }
}
