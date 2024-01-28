import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {
  title = "Teacher Component"
  teachers: any = []


  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllTeacher()
  }
  addTeacher(){
    console.log("add teacher button clicked")
    this.router.navigateByUrl('/add-teacher')
  }
  fetchAllTeacher(){
    this.http.get("http://localhost:8080/teacher/getALl")
    .subscribe( resp =>{
      this.teachers = resp;
      console.log('Teachers retrived successfully:', this.teachers)
    }, error => {
      console.error('Error while retriving teacers:', error);
    }

    );
  }
  deleteTeacher(teacherId: number){
    const url = 'http://localhost:8080/teacher/deleteById/' + teacherId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Teacher deleted successfully', resp)
      this.fetchAllTeacher()
    }, error => {
      console.error("Error in deleting teacher", error)
    }

    );
  }
}
