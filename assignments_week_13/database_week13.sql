create database week13_books_rachana;
use week13_books_rachana;

create table admin(
email_id varchar(100) primary key,
admin_password varchar(100)
);
drop table admin_log_in;

create table books(
book_id int primary key,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_Image_Url varchar(1000),
book_price float,
book_rating float
);

drop table books;


create table User(
email_id varchar (100) primary key,
username varchar(100),
user_password varchar(100) 
);
drop table User;
create table likedBooks(
email_id varchar(100) ,
book_id int primary key,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_Image_Url varchar(1000),
book_price float,
book_rating float,
foreign key (email_id) references  user(email_id),
foreign key (book_id) references books(book_id)
);
 
drop table likedBooks;
 
 create table readLater(
email_id varchar(100) ,
book_id int primary key,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_Image_Url varchar(1000),
book_price float,
book_rating float,
foreign key (email_id) references  user(email_id),
foreign key (book_id) references books(book_id)
);

drop table readlater;


insert into books
value(101,"Wings of Fire","Arun Tiwari","Autobiography","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIbxbKwRE7v4599QdDOor8zzJmtnBV4Vlls7soOOUZSLweNXqnyQ6PNDo071kvo87WlNw&usqp=CAU",
750, 4.8 );
insert into books
value(102, "The Alchemist", " Paulo Coelho", "Adventure fiction", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKOZsc98buRbdG1ufcg3OLiqmey1knQTpF7A&usqp=CAU",
500,4.7 );

insert into books
value (103, "Who Will Cry When you Die?", "Robin Sharma", "Personality Development", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBDkAGpAs7Mpeqae1oP-uYyDM2_0U_tBnk-Q&usqp=CAU", 
350, 4.6 );

insert into books
value (104,"The Power Of Your Subconscious Mind", "Joseph Murphy","Self-Help","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1386924010l/68984.jpg",
 430, 4.7);

insert into books
value(105,"What-If"," Randall Munroe", "Humor", "https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg",
260,4.5);

select * from  admin;
select * from books;
select * from user;
select * from readlater;
select * from likedBooks;
