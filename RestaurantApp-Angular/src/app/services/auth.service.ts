import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable ,of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthRequest } from '../models/AuthRequest';
import { User } from '../models/user';
import { AlertDialogComponent } from '../shared/alert-dialog/alert-dialog.component';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    public dialog: MatDialog,
    private userService:UserService
  ) { }

  signIn(authRequest : AuthRequest): Observable<Boolean> {
    const user =this.userService.getByEmail(authRequest.username);
    var isValid = of(false);
    if(!user){
      return isValid;
    }
    if(user.password!==authRequest.password){
      return isValid;
    }
    localStorage.setItem('RA-user', JSON.stringify(user));
    isValid= of(true);
    return isValid;
  }


  signUp(user : User): Observable<User> {
    this.userService.addNew(user);
    const newUser = of(user);
    return newUser;
  }

}
