import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Books } from './books';
import { UserBooks } from './user-books';
@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(
    public http:HttpClient
  ) { }
  storeBooks(book:any):Observable<String>{
    return this.http.post("http://localhost:8181/book/storeBooks",book,{responseType:'text'})
  }
  loadAllBooks(): Observable<Books[]>{
return this.http.get<Books[]>("http://localhost:8181/book/getAllBooks")
  }
  loadAllBook(): Observable<Books[]>{
    return this.http.get<Books[]>("http://localhost:8282/books/getAllBooks")
      }
  updateBookName(book:any):Observable<String>{
   return this.http.patch("http://localhost:8181/book/updateBookName",book,{responseType:'text'})
  }
  updateAuthor(book:any):Observable<String>{
    return this.http.patch("http://localhost:8181/book/updateAuthor",book,{responseType:'text'})
  }
  updatePrice(book:any):Observable<String>{
    return this.http.patch("http://localhost:8181/book/updateBookPrice",book,{responseType:'text'})
  }
  updateRating(book:any):Observable<String>{
    return this.http.patch("http://localhost:8181/book/updateBookRating",book,{responseType:'text'}) 
  }
  updateGenre(book:any):Observable<String>{
    return this.http.patch("http://localhost:8181/book/updateBookGenre",book,{responseType:'text'})
  }
  deleteBook(bookId:number):Observable<String>{
   return this.http.delete("http://localhost:8181/book/deleteBook/"+bookId,{responseType:'text'})
  }

  storeLikedBook(book:UserBooks):Observable<String>{
    return this.http.post("http://localhost:8282/likedBooks/storeLikeBook",book,{responseType:'text'})
  
  }
  getLikedBooks(email:String):Observable<UserBooks[]>{
    return this.http.get<UserBooks[]>("http://localhost:8282/likedBooks/getLikedBook/"+email)
  }
  storeReadLaterBook(book:UserBooks):Observable<String>{
    return this.http.post("http://localhost:8282/readbooks/storeReadBook",book,{responseType:'text'})
  
  }
  getReadLaterBooks(email:String):Observable<UserBooks[]>{
    return this.http.get<UserBooks[]>("http://localhost:8282/readbooks/getReadBook/"+email)
  }
  getLikedBooksForAdmin(email:String):Observable<UserBooks[]>{
    return this.http.get<UserBooks[]>("http://localhost:8181/likedBooks/getLikedBook/"+email)
  }
}
