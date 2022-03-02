import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import{Admin} from './admin'
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(
    public http:HttpClient
  ) { }

  adminLogin(admin:Admin):Observable<string>{
    return this.http.post("http://localhost:8181/admin/adminLogIn",admin,{responseType:'text'})

  }

  adminSignIn(admin:Admin):Observable<string>{
  return this.http.post("http://localhost:8181/admin/adminSignIn",admin,{responseType:'text'})
  }

 
}
