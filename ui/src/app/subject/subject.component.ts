import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit {

  title = "Subject Component"
  subjects: any = []

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllSubject()
  }
  addSubject(){
    console.log("add subject button clicked")
    this.router.navigateByUrl('/add-subject')
  }
  fetchAllSubject(){
    this.http.get("http://localhost:8080/subject/getAll")
    .subscribe( resp =>{
      this.subjects = resp;
      console.log('Subjects retrived successfully:', this.subjects)
    }, error => {
      console.error('Error while retriving subjects:', error);
    }

    );
  }
  deleteSubject(subId: number){
    const url = 'http://localhost:8080/subject/deleteById/' + subId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Subject deleted successfully', resp)
      this.fetchAllSubject()
    }, error => {
      console.error("Error in deleting subject", error)
    }

    );
  }

}
