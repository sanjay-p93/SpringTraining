import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../models/restaurant';
import { User } from '../models/user';
import { NavBarService } from '../services/nav-bar.service';
import { RestaurantService } from '../services/restaurant.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  constructor(
    private restaurantService: RestaurantService
    ,private userService :UserService,
    private navBarService:NavBarService
  ) { }

  restaurants:Restaurant[] = [];
  user?:User;

  onSelect(restaurant: Restaurant){
    console.log(restaurant);
  }

  getRestaurants(): void {
    this.restaurants=this.restaurantService.getRestaurants();
  }
  

  getUser():void{
    this.user=this.userService.getLoggedUser();
  }

  add(name: string): void {
    name = name.trim();
    if(!name.length){
      return;
    }
    this.restaurantService.addRestaurant(name);
    this.getRestaurants();
  }

  delete(hero: Restaurant): void {
    this.restaurantService.deleteRestaurants(hero.id);
    this.getRestaurants();
  }
  
  ngOnInit(): void {
    this.navBarService.displayNav();
    this.getRestaurants();
    this.getUser();
  }

}
