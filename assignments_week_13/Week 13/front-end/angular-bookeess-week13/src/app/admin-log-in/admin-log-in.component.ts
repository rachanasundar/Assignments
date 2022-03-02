import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-log-in',
  templateUrl: './admin-log-in.component.html',
  styleUrls: ['./admin-log-in.component.css']
})
export class AdminLogInComponent implements OnInit {
loginRef = new FormGroup({
  emailId:new FormControl("", Validators.required),
  adminPassword:new FormControl("", Validators.required)
});
signinRef = new FormGroup({
  emailId:new FormControl("", Validators.required),
  adminPassword:new FormControl("", Validators.required)
});
flag:boolean=true;
signinFlag:boolean=false;
loginResult:string="";
signinResult:string="";

  constructor(public admin:AdminService,
    public router:Router) { }

  ngOnInit(): void {
  }
  
  signIn():void{
    this.signinFlag = true;
    
  }
  storeAdmin():void{
let sigin = this.signinRef.value;
console.log(sigin);
sessionStorage.setItem("admin", sigin.emailId)
this.admin.adminSignIn(sigin).subscribe(
  result=>{this.signinResult=result
    this.goToHome()
    alert(result)
  },error=>console.log(error)
  
)
this.flag =false

  }

  checkAdmin():void{
    let login = this.loginRef.value;
    console.log(login);
    sessionStorage.setItem("admin", login.emailId)
    this.admin.adminLogin(login).subscribe(
      result=>{this.loginResult=result
      this.goToHome()
        alert(result)
      },error=>console.log(error)
    )
    this.flag =false  
    this.loginRef.reset();
  }

  goToHome(){
    sessionStorage.setItem("adminLogin",this.loginResult);
    sessionStorage.setItem("adminSignin",this.signinResult);
     this.router.navigate(["home"]);
  }
}
