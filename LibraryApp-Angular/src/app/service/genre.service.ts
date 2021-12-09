import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  GENRE:string[]=['Fantasy','Thriller','Horror','Historical','Romance'];
  constructor() { }

  get():string[]{
    return this.GENRE;
  }
  
  add(genre:string):string[]{
    this.GENRE.push(genre);
    return this.GENRE;
  }

  remove(genre:string){
    this.GENRE=this.GENRE.filter(x=>x!=genre);
  }
}
