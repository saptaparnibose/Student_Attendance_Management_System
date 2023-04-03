import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  title = "Book Components"
  books:any = []
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllBook()
  }
  addBook(){
    console.log("add book button clicked")
    this.router.navigateByUrl('/add-book')
  }

  fetchAllBook(){
    this.http.get("http://localhost:8080/book/getALl")
    .subscribe( resp =>{
      this.books = resp;
      console.log('Books retrived successfully:', this.books)
    }, error => {
      console.error('Error while retriving books:', error);
    }

    );
  }
  deleteBook(bookId:Number){
    const url = 'http://localhost:8080/book/deleteById/' + bookId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Book deleted successfully', resp)
      this.fetchAllBook()
    }, error => {
      console.error("Error in deleting book", error)
    }

    );
  }
}
