import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { StudentComponent } from './student/student.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HomeComponent } from './home/home.component';
import { UpnavComponent } from './upnav/upnav.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddStudentComponent } from './add-student/add-student.component';
import { HttpClientModule} from '@angular/common/http';
import { TeacherComponent } from './teacher/teacher.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { SubjectComponent } from './subject/subject.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    StudentComponent,
    SidenavComponent,
    HomeComponent,
    UpnavComponent,
    AddAdminComponent,
    AddStudentComponent,
    TeacherComponent,
    AddTeacherComponent,
    SubjectComponent,
    AddSubjectComponent,
    AttendanceComponent,
    AddAttendanceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
