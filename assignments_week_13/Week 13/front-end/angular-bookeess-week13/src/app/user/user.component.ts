import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
usersList:Array<User>=[];
  constructor(
    public userService:UserService,
    public router:Router
  ) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers(){
this.userService.getAllUsers().subscribe(
  res=>this.usersList=res,
  error=>console.log(error)
)

  }
  storeFlag:boolean=false
  updateFlag:boolean=false
  emailId:String=''
  username:String=''
  userPassword:String=''
  storeMsg:String=''
  storeUserBtn(){
this.storeFlag=true
  }
  storeuser(){
    let user ={"emailId":this.emailId,"username":this.username,"userPassword":this.userPassword}
     this.userService.storeUser(user).subscribe(
       res=>this.storeMsg=res,
       error=>console.log(error),
       ()=>this.loadUsers()
     )
     this.storeFlag=false
  }



  updateUserBtn(user:User){
this.updateFlag=true
this.emailId=user.emailId
this.username=user.username
this.userPassword=user.userPassword

  }
  updateMsg:String=""
  updateName(){
    let user ={"emailId":this.emailId,"username":this.username}
    this.userService.updateName(user).subscribe(
      res=>this.updateMsg=res,
      error=>console.log(error),
      ()=>this.loadUsers()
    )
    this.updateFlag = false
  }
  updatePass(){
    let user ={"emailId":this.emailId,"userPassword":this.userPassword}
    this.userService.updatePass(user).subscribe(
      res=>this.updateMsg=res,
      error=>console.log(error),
      ()=>this.loadUsers()
    )
    this.updateFlag = false
  }
  deleteMsg:String=''
  deleteUser(emailId:String){
    this.userService.delete(emailId).subscribe(
      res=>this.deleteMsg=res,
      error=>console.log(error),
      ()=>this.loadUsers()

      
    )
  }

  find(){
    this.router.navigate(["find"]);
  }
}
