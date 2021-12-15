import { Component, OnInit } from '@angular/core';
import { count } from 'rxjs/operators';
import { NavBarService } from '../services/nav-bar.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
    private navBarService:NavBarService,
    private userService:UserService,
  ) { }

  isActive:boolean=false;

  setNavBar(){
    this.navBarService.isActive$.subscribe(isActive=>{
      console.log(isActive);
      this.isActive=isActive;
    });
  }

  logOut(){
    this.userService.logOut();
  }

  ngOnInit(): void {
    this.setNavBar();
  }

}
