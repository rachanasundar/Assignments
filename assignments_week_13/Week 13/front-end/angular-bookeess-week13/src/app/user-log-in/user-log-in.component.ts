import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserService } from '../user.service';

@Component({
  selector: 'app-user-log-in',
  templateUrl: './user-log-in.component.html',
  styleUrls: ['./user-log-in.component.css']
})
export class UserLogInComponent implements OnInit {
  loginRef = new FormGroup({
    emailId:new FormControl("", Validators.required),
    userPassword:new FormControl("", Validators.required)
  });
  signinRef = new FormGroup({
    emailId:new FormControl("", Validators.required),
    username:new FormControl("", Validators.required),
    userPassword:new FormControl("", Validators.required)
  });
  flag:boolean=true;
  signinFlag:boolean=false;
  loginResult:string="";
  signinResult:string="";

  constructor(
    public user:UserService,
    
    public router:Router
    ) { }

  ngOnInit(): void {
    
  }
  signIn(){
    this.signinFlag=true;
  }
  storeUser():void{
    let sigin = this.signinRef.value;
    console.log(sigin);
    sessionStorage.setItem("user", sigin.emailId)
    this.user.userSignIn(sigin).subscribe(
      result=>{this.signinResult=result 
        this.goToHome()
        alert(result)
        
      },error=>console.log(error)
    )
    this.flag =false
        this.signinRef.reset();
      }
    
      checkUser():void{
        let login = this.loginRef.value;
        sessionStorage.setItem("user", login.emailId)
        this.user.userLogin(login).subscribe(
          result=>{
            this.loginResult=result
            this.goToHome()
            alert(result)
            
            
          },error=>console.log(error)
        )
        this.flag =false
        console.log(this.loginResult)

        this.loginRef.reset(); 

      }

      goToHome(){
        sessionStorage.setItem("login",this.loginResult);
        sessionStorage.setItem("signin",this.signinResult);
         this.router.navigate(["home"]);
      }

    
}
