import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {

  teacherForm : FormGroup;

  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.teacherForm = this.formbuilder.group({
      name: ['', Validators.required],
    })
  }

  ngOnInit(): void {
  }
  saveTeacher(){
    let teacherData = this.teacherForm.value;
    this.http.post('http://localhost:8080/teacher/saveTeacher', teacherData)
    .subscribe( response => {
      console.log('Teacher saved successfully', response)
      this.router.navigateByUrl('/teacher')
    }, error => {
      console.error("Error in teacher save", error)
    }

    );
  }

}
