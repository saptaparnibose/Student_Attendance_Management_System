import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { AuthorComponent } from './author/author.component';
import { AdminComponent } from './admin/admin.component';
import { StudentComponent } from './student/student.component';
import { PublisherComponent } from './publisher/publisher.component';
import { LoanComponent } from './loan/loan.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HomeComponent } from './home/home.component';
import { UpnavComponent } from './upnav/upnav.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddBookComponent } from './add-book/add-book.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddStudentComponent } from './add-student/add-student.component';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AuthorComponent,
    AdminComponent,
    StudentComponent,
    PublisherComponent,
    LoanComponent,
    SidenavComponent,
    HomeComponent,
    UpnavComponent,
    AddAdminComponent,
    AddBookComponent,
    AddStudentComponent,
    AddPublisherComponent,
    AddAuthorComponent
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
