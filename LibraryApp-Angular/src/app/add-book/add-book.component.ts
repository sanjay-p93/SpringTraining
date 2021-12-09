import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from '../model/book';
import { BookService } from '../service/book.service';
import { GenreService } from '../service/genre.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(
    private bookService:BookService, 
    private fb: FormBuilder,
    private router: Router,
    private genreservice:GenreService
  ) { }
  
  book!:Book;
  bookForm!: FormGroup;
  genres:string[]=[];
 
  getGenre(){
    this.genres=this.genreservice.get();
    console.log(this.genres);
  }

  createForm(){
    this.bookForm = this.fb.group({
      name:                 ["",[Validators.required,Validators.maxLength(25)]],
      description :         ["",[Validators.required,Validators.maxLength(100)]],
      price :               ["",[Validators.required,Validators.pattern("^[0-9]{1,5}$")]],
      genre :            ["",[Validators.required]],
    });
  }
 
  
  save(){
    if(!this.bookForm.valid) {
      this.bookForm.markAllAsTouched();
      return;
    }
    const newBook:Book=Object.assign({id:""},this.bookForm.value);
    this.bookForm.disable();
    console.log(newBook);//test
    this.bookService.addNew(newBook);
    this.router.navigate(['home']);
  }

  ngOnInit(): void {
    this.getGenre();
    this.createForm();
  }

}
