import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  title = "Student Component"
  students: any = []
  isGreen = false
  isRad = true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudent()
  }
  addStudent(){
    console.log("add book button clicked")
    this.router.navigateByUrl('/add-student')
  }

  fetchAllStudent(){
    this.http.get("http://localhost:8080/Student/getALl")
    .subscribe( resp =>{
      this.students = resp;
      console.log('Students retrived successfully:', this.students)
    }, error => {
      console.error('Error while retriving students:', error);
    }

    );
  }
  deleteStudent(studentId:Number){
    const url = 'http://localhost:8080/Student/deleteById/' + studentId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Student deleted successfully', resp)
      this.fetchAllStudent()
    }, error => {
      console.error("Error in deleting student", error)
    }

    );
  }
}