import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  adminLoginResult:boolean=false;
  userLoginResult:boolean=false;
  constructor() { }
  setAdminResult(result:boolean):void{
this.adminLoginResult =result;
  }
  getAdminResult():boolean{
    return this.adminLoginResult;
  }
  setUserResult(result:boolean):void{
this.userLoginResult=result;
  }
  getUserResult():boolean{
    return this.userLoginResult;
  }

}
