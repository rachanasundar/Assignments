import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Books } from '../books';
import { BooksService } from '../books.service';
import { UserBooks } from '../user-books';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
books:Array<Books>=[];
adminFlag:boolean=false;
name:string=''
flag:boolean=false
userFlag:boolean=false
updateFlag:boolean =false

addBookFlag:boolean =false
updatenameFlag:boolean =false
updateAuthorFlag:boolean =false
updatePriceFlag:boolean =false
updateGenreFlag:boolean =false
updateRatingFlag:boolean =false
bookId:number=0;
bookName:String=''
author:String=''
bookGenre:String=''
bookImageUrl:String=''
bookPrice:number=0;
bookRating:number=0
  constructor(
    public bookService:BooksService,
    public router:Router

  ) { }

  ngOnInit(): void {
    
     let obj1 =sessionStorage.getItem("name");
     let obj2 =sessionStorage.getItem("adminFlag")
    if(obj1!=null){
      this.name= obj1
      sessionStorage.setItem("name",this.name)
      this.flag=true
      this.userFlag=true
      this.loadUserBooks()
       }
       if(obj2!=null&& obj2 == "1"){
        this.adminFlag=true
        this.flag=false
      this.userFlag=false
        this.loadBooks()
     }
    
  }
  loadBooks(){
    // console.log("event");
    this.bookService.loadAllBooks().subscribe(
      res=>this.books=res,
      error=>console.log(error),
       )
}
loadUserBooks(){
  // console.log("event");
  this.bookService.loadAllBook().subscribe(
    res=>this.books=res,
    error=>console.log(error),
     )
}
updateBtn(book:Books){
  console.log("event update")
  this.updateFlag =true
  this.bookId=book.bookId
this.bookName=book.bookName
this.author=book.author
this.bookGenre=book.bookGenre
this.bookImageUrl=book.bookImageUrl
this.bookPrice= book.bookPrice
this.bookRating=book.bookRating
}
addBookBtn(){
  console.log("add event")
  this.addBookFlag=true
}
updateBookNameBtn(){
  console.log(this.bookId)
  this.updatenameFlag=true
}
updateAuthorBtn(){
  this.updateAuthorFlag= true
  console.log(this.bookId)
}
updatePriceBtn(){
  this.updatePriceFlag=true
  console.log(this.bookId)
}
updateRatingBtn(){
  this.updateRatingFlag =true
  console.log(this.bookId)
}
updateGenreBtn(){
  this.updateGenreFlag= true
  console.log(this.bookId)
}
Msg:String=""
newBookRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  bookName:new FormControl("", Validators.required),
  author:new FormControl("", Validators.required),
  bookGenre:new FormControl("", Validators.required),
  bookImageUrl:new FormControl("", Validators.required),
  bookPrice:new FormControl("", Validators.required),
  bookRating:new FormControl("", Validators.required),
})
addBook(){
  let book =this.newBookRef.value
//   let book ={
//     "bookId":this.bookId,
//     "bookName":this.bookName,
// "author":this.author,
// "bookGenre":this.bookGenre,
// "bookImageUrl":this.bookImageUrl,
// "bookPrice":this.bookPrice,
// "bookRating":this.bookRating
 
//   }
  this.bookService.storeBooks(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
  )
this.addBookFlag =false
}
nameRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  bookName:new FormControl("", Validators.required)
})
updateBookName(){
  console.log(this.bookId)
  let book = this.nameRef.value
  console.log(book)

  this.bookService.updateBookName(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
  this.updatenameFlag=false
}

priceRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  bookPrice:new FormControl("", Validators.required)
})
updatePrice(){
  console.log(this.bookId)
  let book = this.priceRef.value
  console.log(book)
  this.bookService.updatePrice(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
  this.updatePriceFlag=false
}

rateRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  bookRating:new FormControl("", Validators.required)
})
updateRating(){
  console.log(this.bookId)
  let book = this.rateRef.value
  console.log(book)
  this.bookService.updateRating(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
  this.updateRatingFlag =false
}

genreRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  bookGenre:new FormControl("", Validators.required)
})
updateGenre(){
  let book = this.genreRef.value
  console.log(book)
  this.bookService.updateGenre(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
  this.updateGenreFlag=false
}
authorRef=new FormGroup({
  bookId:new FormControl("", Validators.required),
  author:new FormControl("", Validators.required)
})
updateAuthor(){
  let book = this.authorRef.value
  console.log(book)
  this.bookService.updateAuthor(book).subscribe(
    res=>this.Msg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
  this.updateAuthorFlag=false
}
deleteMsg:String=''
deleteBook(bid:number){
  // console.log("event delete")
  this.bookService.deleteBook(bid).subscribe(
    res=>this.deleteMsg=res,
    error=>console.log(error),
    ()=>this.loadBooks()
  )
}

like(book:Books){
let likebook:UserBooks={
  "keys":{
    "emailId":this.name,
    "bookId":book.bookId},
  "bookName":book.bookName,
  "author":book.author,
  "bookGenre":book.bookGenre,
  "bookImageUrl":book.bookImageUrl,
  "bookPrice":book.bookPrice,
  "bookRating":book.bookRating
  

}
console.log(likebook)
this.bookService.storeLikedBook(likebook).subscribe(
  result=>alert(result),
  error=>console.log(error),
  ()=>this.loadUserBooks()
)
}
readLater(book:any){
  let readbook:UserBooks={
    "keys":{
    "emailId":this.name,
    "bookId":book.bookId},
    "bookName":book.bookName,
    "author":book.author,
    "bookGenre":book.bookGenre,
    "bookImageUrl":book.bookImageUrl,
    "bookPrice":book.bookPrice,
    "bookRating":book.bookRating
  
  }
  this.bookService.storeReadLaterBook(readbook).subscribe(
    result=>alert(result),
    error=>console.log(error),
    ()=>this.loadUserBooks()
  )
}
likepage(){
  this.router.navigate(["like"]);
}
readpage(){
  this.router.navigate(["read"]);
}
}
