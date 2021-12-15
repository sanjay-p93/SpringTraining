import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../models/menu';
import { Restaurant } from '../models/restaurant';
import { User } from '../models/user';
import { NavBarService } from '../services/nav-bar.service';
import { RestaurantService } from '../services/restaurant.service';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-resturant-menu',
  templateUrl: './resturant-menu.component.html',
  styleUrls: ['./resturant-menu.component.css']
})
export class ResturantMenuComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private userService :UserService,
    private restaurantService: RestaurantService, 
    private router: Router,
    private navBarService:NavBarService  ) { }

  restaurant?:Restaurant;
  user?:User;
  cart:Menu[]=[];

  getResturant():void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    console.log(id);
    this.restaurant=this.restaurantService.getRestaurantByid(id);
  }

  getUser():void{
    this.user=this.userService.getLoggedUser();
  }

  addToCart(menu:Menu){
    if(this.user?.role!="USER"){
      return;
    }
    for(let x of this.cart){
        if(x.id==menu.id)
          return;
    }
    this.cart.push(menu);
  }
  
  checkOut(){
    this.cart=[];
    this.router.navigate(['/success'])
  }

  ngOnInit(): void {
    this.navBarService.displayNav();
    this.getUser();
    this.getResturant();
  }

}
