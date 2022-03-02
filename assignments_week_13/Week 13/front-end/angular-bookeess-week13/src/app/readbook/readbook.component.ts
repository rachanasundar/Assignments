import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { UserBooks } from '../user-books';

@Component({
  selector: 'app-readbook',
  templateUrl: './readbook.component.html',
  styleUrls: ['./readbook.component.css']
})
export class ReadbookComponent implements OnInit {
  name:String=''
  readBook:Array<UserBooks>=[]
  constructor(
    public bookService:BooksService
  ) { }

  ngOnInit(): void {
    let obj1 =sessionStorage.getItem("name");
    if(obj1!=null){
      this.name= obj1
      this.loadReadBooks()
  }
  }
  loadReadBooks(){
    this.bookService.getReadLaterBooks(this.name).subscribe(
      result=>this.readBook=result,
      error=>console.log(error)
    )
  }
}
