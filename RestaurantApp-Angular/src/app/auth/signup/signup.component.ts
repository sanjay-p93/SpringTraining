import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/models/AuthRequest';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { NavBarService } from 'src/app/services/nav-bar.service';
import { AlertDialogComponent } from 'src/app/shared/alert-dialog/alert-dialog.component';
import { PasswordValidator } from 'src/app/shared/password.validator';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  constructor(
    private formBuilder: FormBuilder,
    private authService:AuthService,
    private router: Router,
    public dialog: MatDialog,
    private navBarService:NavBarService,
    ) { }

  signupForm!: FormGroup;
  passwordEmpty:boolean=false;
  
  roles:string[]=['OWNER','USER','ADMIN'];

  setUserDetails(){
    this.signupForm = this.formBuilder.group({
      name:             ["",[Validators.required,Validators.maxLength(25)]],
      password :        ["",Validators.required],
      confimPassword :  ["",Validators.required],
      email :           ["",[Validators.required,Validators.email]],
      role :  ["",Validators.required],
    }, { validators: PasswordValidator });

  }

  signUp(){
    if(!this.signupForm.valid) {
      this.signupForm.markAllAsTouched();
      return
    }
    const formValue = this.signupForm.value;
    const user  = <User>formValue;
    this.authService.signUp(user);
    this.signIn(user);
  }
  
  signIn(user:User){
    const authRequest : AuthRequest ={username:user.email,password:user.password};
    this.authService.signIn(authRequest).subscribe(result=>{
        if(result){
          this.router.navigate(['dashboard']);
        }
    });
  }

  ngOnInit(): void {
    this.navBarService.hideNav();
    this.setUserDetails();
  }
}
