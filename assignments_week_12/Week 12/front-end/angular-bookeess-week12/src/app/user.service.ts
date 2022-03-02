import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    public http:HttpClient
  ) { }

  userLogin(user:User):Observable<string>{
    return this.http.post("http://localhost:8282/user/userLogIn",user,{responseType:'text'})
  }

  userSignIn(user:User):Observable<string>{
  return this.http.post("http://localhost:8282/user/userSignIn",user,{responseType:'text'})
  }
  storeUser(user:User):Observable<string>{
    return this.http.post("http://localhost:8181/userCurd/storeUserInfo",user,{responseType:'text'})
    }
  getAllUsers():Observable<User[]>{
    return this.http.get<User[]>("http://localhost:8181/userCurd/getAllUser")
      }
   updateName(user:any):Observable<string>{
return this.http.patch("http://localhost:8181/userCurd/updateUserName",user,{responseType:'text'})
   } 
   updatePass(user:any):Observable<string>{
    return this.http.patch("http://localhost:8181/userCurd/updateUserPassword",user,{responseType:'text'})
   } 
   delete(emailId:String):Observable<string>{
    return this.http.delete("http://localhost:8181/userCurd/deleteUserInfo/"+emailId,{responseType:'text'})
   }  
}
