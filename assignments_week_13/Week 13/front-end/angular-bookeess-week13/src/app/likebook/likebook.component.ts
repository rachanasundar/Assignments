import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { UserBooks } from '../user-books';

@Component({
  selector: 'app-likebook',
  templateUrl: './likebook.component.html',
  styleUrls: ['./likebook.component.css']
})
export class LikebookComponent implements OnInit {
name:String=''
likedBook:Array<UserBooks>=[]
  constructor(
    public bookService:BooksService
  ) { }

  ngOnInit(): void {
    let obj1 =sessionStorage.getItem("name");
    if(obj1!=null){
      this.name= obj1
      this.loadLikeBooks()
  }
}
loadLikeBooks(){
  this.bookService.getLikedBooks(this.name).subscribe(
    result=>this.likedBook=result,
    error=>console.log(error)
  )
}
    

  
}
