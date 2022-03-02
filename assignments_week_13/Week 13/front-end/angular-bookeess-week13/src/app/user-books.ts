export class UserBooks {
    constructor(
        public keys :{
             emailId:String,
             bookId:number,
        },
        
        public bookName:String,
        public author:String,
        public bookGenre:String,
        public bookImageUrl:String,
        public bookPrice:number,
        public bookRating:number
    ){

    }
}
