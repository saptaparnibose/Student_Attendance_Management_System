import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  title = "Author Component"
  authors: any = []
  isGreen = false
  isRad = true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthor()
  }
  addAuthor(){
    console.log("add book button clicked")
    this.router.navigateByUrl('/add-author')
  }
  fetchAllAuthor(){
    this.http.get("http://localhost:8080/author/getALl")
    .subscribe( resp =>{
      this.authors = resp;
      console.log('Authors retrived successfully:', this.authors)
    }, error => {
      console.error('Error while retriving authors:', error);
    }

    );
  }
  deleteAuthor(auId: number){
    const url = 'http://localhost:8080/author/deleteById/' + auId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Author deleted successfully', resp)
      this.fetchAllAuthor()
    }, error => {
      console.error("Error in deleting author", error)
    }

    );
  }
}
