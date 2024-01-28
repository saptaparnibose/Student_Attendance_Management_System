import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-attendance',
  templateUrl: './add-attendance.component.html',
  styleUrls: ['./add-attendance.component.css']
})
export class AddAttendanceComponent implements OnInit {

  attendanceForm : FormGroup;

  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.attendanceForm = this.formbuilder.group({
      name: ['', Validators.required],
      attended: [, Validators.required],
      total: [, Validators.required],
      date: [, Validators.required]
    })
  }

  ngOnInit(): void {
  }
  saveAttendance(){
    let attendanceData = this.attendanceForm.value;
    this.http.post('http://localhost:8080/attendance/saveAttendance', attendanceData)
    .subscribe( response => {
      console.log('Attendance saved successfully', response)
      this.router.navigateByUrl('/attendance')
    }, error => {
      console.error("Error in attendance save", error)
    }

    );
  }

}
