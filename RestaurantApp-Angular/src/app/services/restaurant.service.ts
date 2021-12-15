import { Injectable } from '@angular/core';
import { Menu } from '../models/menu';
import { Restaurant } from '../models/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  RESTAURANTS: Restaurant[] = [];
  constructor() { 
  }

  getRestaurants(): Restaurant[]{
    return this.RESTAURANTS;
  }

  getRestaurantByid(id?:Number):Restaurant{
    for(let x of this.RESTAURANTS){
      if(x.id==id)
      return x;    
    }
    let x:Restaurant={id:0,name:"",menuList:[]};
    return x;

  }

  addRestaurant(name:String):Restaurant{
    let idx: number=1;
    if(this.RESTAURANTS.length>0){
      idx=this.RESTAURANTS[this.RESTAURANTS.length-1].id+ 1;
    }
    let newRestaurant :Restaurant={id:idx,name:name,menuList:[]};
    this.RESTAURANTS.push(newRestaurant);
    return newRestaurant;
  }


  deleteRestaurants(id:Number){
     this.RESTAURANTS = this.RESTAURANTS.filter(x => {
      return x.id != id;
    })
  }

  addMenu(menu:Menu,id?:Number){
    this.RESTAURANTS.forEach(x=>{
      if(x.id==id)
        x.menuList.push(menu);
    });
  }

  removeMenu(menuId:Number){
    this.RESTAURANTS.forEach(x=>{
      x.menuList=x.menuList.filter(m => {return m.id != menuId;});
    });
  }

  removeMenuById(menu:Menu,id?:Number){
    this.RESTAURANTS.forEach(x=>{
      if(x.id==id)
        x.menuList=x.menuList.filter(m => {return m.id != menu.id;});
    });
  }

}
