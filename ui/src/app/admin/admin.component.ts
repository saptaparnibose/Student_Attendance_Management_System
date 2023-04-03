import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  title = "Admin Component"
  admins: any = []
  isGreen = false
  isRad = true
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAdmin()
  }
  addAdmin(){
    console.log("add admin button clicked")
    this.router.navigateByUrl('/add-admin')
  }
  fetchAllAdmin(){
    this.http.get("http://localhost:8080/admin/getALl")
    .subscribe( resp =>{
      this.admins = resp;
      console.log('Admins retrived successfully:', this.admins)
    }, error => {
      console.error('Error while retriving admins:', error);
    }

    );
  }
  deleteAdmin(adminId: number){
    const url = 'http://localhost:8080/admin/deleteById/' + adminId
    console.log(url)
    this.http.delete(url)
    .subscribe( resp => {
      console.log('Admin deleted successfully', resp)
      this.fetchAllAdmin()
    }, error => {
      console.error("Error in deleting admin", error)
    }

    );
  }
}
