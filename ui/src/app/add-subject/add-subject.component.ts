import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.css']
})
export class AddSubjectComponent implements OnInit {

  subjectForm : FormGroup;

  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.subjectForm = this.formbuilder.group({
      subjectCode: ['', Validators.required],
      subjectName: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }
  saveSubject(){
    let subjectData = this.subjectForm.value;
    this.http.post('http://localhost:8080/subject/saveSubject', subjectData)
    .subscribe( response => {
      console.log('Subject saved successfully', response)
      this.router.navigateByUrl('/subject')
    }, error => {
      console.error("Error in subject save", error)
    }

    );
  }

}
