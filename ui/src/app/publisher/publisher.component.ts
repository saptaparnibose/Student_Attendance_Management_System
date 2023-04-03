import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {
  title = "Publisher Component"
  publishers: any = []
  isGreen = false
  isRad = true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublisher()
  }
  addPublisher(){
    console.log("add book button clicked")
    this.router.navigateByUrl('/add-publisher')
  }
  fetchAllPublisher(){
    this.http.get("http://localhost:8080/publisher/getALl")
    .subscribe( resp =>{
      this.publishers = resp;
      console.log('Publishers retrived successfully:', this.publishers)
    }, error => {
      console.error('Error while retriving publishers:', error);
    }

    );
  }
  deletePublisher(pubId: number){
    const url = 'http://localhost:8080/publisher/deleteById/' + pubId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Publisher deleted successfully', resp)
      this.fetchAllPublisher()
    }, error => {
      console.error("Error in deleting publisher", error)
    }

    );
  }
}
