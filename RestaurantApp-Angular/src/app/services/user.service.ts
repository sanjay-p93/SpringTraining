import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  USERS:User[]=[];

  constructor(
    private router: Router
  ) { }

  getAll():User[]{
    return this.USERS;
  }

  getByEmail(email:string):User{
    return this.USERS.filter(x=>x.email===email)[0];
  }

  addNew(user:User):User{
    let listSize = this.USERS.length;
    console.log(user);
    if(listSize==0){
      user.id=1;
    }
    else{
      user.id=this.USERS[listSize-1].id+1;
    }
    this.USERS.push(user);
    console.log(this.USERS);
    return user;
  }

  deleteById(id:number){
    this.USERS = this.USERS.filter(x=>x.id!=id);
  }

  getLoggedUser(){
    var USER = localStorage.getItem('RA-user');
    if(USER){
      console.log(USER);
      let user: User = JSON.parse(USER);
      return user;
    }
    return undefined;
  }

  logOut() {
    console.log("here");
    localStorage.clear();
    this.router.navigate(['signin']);
  }
}
