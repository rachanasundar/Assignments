import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BooksService } from '../books.service';
import { UserBooks } from '../user-books';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  likedBook:Array<UserBooks>=[]
  constructor(
    public bookservice:BooksService
  ) { }

  ngOnInit(): void {
  }
  find(findRef:NgForm){
    let user=findRef.value
    this.bookservice.getLikedBooksForAdmin(user.user).subscribe(
      res=>this.likedBook=res,
      error=>console.log(error)
    )
  }
}
