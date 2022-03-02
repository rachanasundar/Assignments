import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { BooksComponent } from './books/books.component';
import { AppRoutingModule } from './app-routing.module';
import { AdminLogInComponent } from './admin-log-in/admin-log-in.component';
import { UserLogInComponent } from './user-log-in/user-log-in.component';
import{FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeadderComponent } from './headder/headder.component';
import { UserComponent } from './user/user.component'
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    BooksComponent,
    AdminLogInComponent,
    UserLogInComponent,
    DashboardComponent,
    HeadderComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,AppRoutingModule,ReactiveFormsModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
