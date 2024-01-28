import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {

  title = "Attendance Component"
  attendances: any = []
  isGreen = false
  isRad = true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAttendance()
  }
  addAttendance(){
    console.log("add attendance button clicked")
    this.router.navigateByUrl('/add-attendance')
  }
  fetchAllAttendance(){
    this.http.get("http://localhost:8080/attendance/getALl")
    .subscribe( resp =>{
      this.attendances = resp;
      console.log('Attendances retrived successfully:', this.attendances)
    }, error => {
      console.error('Error while retriving attendances:', error);
    }

    );
  }
  deleteAttendance(attendanceId: number){
    const url = 'http://localhost:8080/attendance/deleteById/' + attendanceId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('AttendanceId deleted successfully', resp)
      this.fetchAllAttendance()
    }, error => {
      console.error("Error in deleting attendance", error)
    }

    );
  }

}
