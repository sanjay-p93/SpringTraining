import { Injectable } from '@angular/core';
import { Book } from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  BOOKS:Book[]=[];

  constructor() { }

  getAll():Book[]{
    return this.BOOKS;
  }

  addNew(book:Book):Book{
    let listSize = this.BOOKS.length;
    console.log(book);
    if(listSize==0){
      book.id=1;
    }
    else{
      book.id=this.BOOKS[listSize-1].id+1;
    }
    this.BOOKS.push(book);
    return book;
  }

  deleteById(id:number){
    this.BOOKS = this.BOOKS.filter(x=>x.id!=id);
  }
  
}
