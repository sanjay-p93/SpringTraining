import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books:Book[]=[];
  constructor(private bookService:BookService) { }

  getAllBooks(){
    this.books=this.bookService.getAll();
    console.log(this.books);
  }

  delete(book:Book){
    this.bookService.deleteById(book.id);
    this.getAllBooks();
  }


  ngOnInit(): void {
    this.getAllBooks();
  }

}
