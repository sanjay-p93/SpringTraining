import { Injectable } from '@angular/core';
import { Menu } from '../models/menu';
import { RestaurantService } from './restaurant.service';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  MENUS: Menu[] = [];
  constructor(
    private restaurantService: RestaurantService) { 
  }

  getMenu(): Menu[]{
    return this.MENUS;
  }

  addMenu(name:string):Menu{
    let idx: number=1;
    if(this.MENUS.length>0){
      idx=this.MENUS[this.MENUS.length-1].id+ 1;
    }
    let newMenu :Menu={id:idx,name:name};
    this.MENUS.push(newMenu);
    return newMenu;
  }


  deleteMenu(id:Number){
    this.restaurantService.removeMenu(id);
    this.MENUS = this.MENUS.filter(x => {
      return x.id != id;
    })
  }
}
