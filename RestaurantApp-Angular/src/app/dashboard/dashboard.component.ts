import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user?:User;
  constructor(private userService :UserService) { }

  ngOnInit(): void {
    this.user=this.userService.getLoggedUser();
    console.log(this.user);
  }

}
