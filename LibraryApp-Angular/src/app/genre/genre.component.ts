import { Component, OnInit } from '@angular/core';
import { GenreService } from '../service/genre.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {

  constructor(private genreservice:GenreService) { }
  
  genres:string[]=[];
  newGenre:string='';

  getGenre(){
    this.genres=this.genreservice.get();
    console.log(this.genres);
  }
  add(){
    if(this.newGenre==''){
      return;
    }
    this.genreservice.add(this.newGenre);
    this.newGenre='';
    this.getGenre();
  }

  delete(genre:string){
    this.genreservice.remove(genre);
    this.getGenre();
  }

  ngOnInit(): void {
    this.getGenre();
  }

}
