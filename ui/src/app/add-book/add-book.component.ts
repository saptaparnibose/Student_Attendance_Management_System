import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { constants } from 'buffer';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  bookForm : FormGroup;

  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.bookForm = this.formbuilder.group({
      title: ['', Validators.required],
      author: ['', Validators.required],
      isbn: [0],
      publicationDate: [''],
      publisher: [''],
      copies:[1],
      category: [''],
      genre: [''],
      subgenre: ['']
    })
  }

  ngOnInit(): void {
  }
  saveBook(){

    let bookData = this.bookForm.value;
    this.http.post('http://localhost:8080/book/saveBook', bookData)
    .subscribe( response => {
      console.log('Book saved successfully', response)
      this.router.navigateByUrl('/book')
    }, error => {
      console.error("Error in book save", error)
    }

    );
  }
}
