import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { TeacherComponent } from './teacher/teacher.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';
import { SubjectComponent } from './subject/subject.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { AttendanceComponent } from './attendance/attendance.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'admin',
    component: AdminComponent,
  },
  {
    path: 'student',
    component: StudentComponent,
  },
  {
    path: 'add-admin',
    component: AddAdminComponent,
  },
  {
    path: 'add-student',
    component: AddStudentComponent,
  },
  {
    path: 'teacher',
    component: TeacherComponent,
  },
  {
    path: 'add-teacher',
    component: AddTeacherComponent,
  },
  {
    path: 'subject',
    component: SubjectComponent,
  },
  {
    path: 'add-subject',
    component: AddSubjectComponent,
  },
  {
    path: 'attendance',
    component: AttendanceComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
