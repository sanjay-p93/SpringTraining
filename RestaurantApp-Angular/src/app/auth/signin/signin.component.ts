import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/models/AuthRequest';
import { AuthService } from 'src/app/services/auth.service';
import { NavBarService } from 'src/app/services/nav-bar.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor( 
    private formBuilder: FormBuilder, 
    private authService:AuthService,
    private router: Router,
    private navBarService:NavBarService,
  ) { }

  signinForm!: FormGroup;

  setUserDetails(){
    this.signinForm = this.formBuilder.group({
      email:             ["",[Validators.required,Validators.email]],
      password :        ["",Validators.required],
    });

  }

  signIn(){
    if(!this.signinForm.valid) {
      this.signinForm.markAllAsTouched();
      return;
    }
    const formValue = this.signinForm.value;
    const authRequest : AuthRequest ={username:formValue["email"],password:formValue["password"]};
    this.authService.signIn(authRequest).subscribe(result=>{
        console.log(result);
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
